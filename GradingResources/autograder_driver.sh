#!/usr/bin/env bash
# This script runs the operations that are common to all weeks of 
# autograding. It expects the following two things to be defined:
#
# $JAVA_MODULES an array of the Java class names expected for the assignment.
#
# gradeModule() will provide a case statement that will do the grading
#               for each of the modules. The current module is available
#               to this function as $module
#
# An individual week's autograder script would first define these two 
# functions, and then source this file.
# 
# Here are the variables that can be used in the gradeModules() function:
# 
# $module - The current module being processed. Its value is one of the
#           module identifiers defined in $JAVA_MODULES.
#
# $javaPath  - The full path to the current Java source file (may have spaces)
# $javaFile  - The Java source file, no path
# $javaClass - The name of the current Java class (without .class at the end)
# $submissionDir - The root of the student's submission directory (may have spaces)
# $RESULT    - The name of the output file that is collecting all of the output
#              from the grading process. You should only append to this file.
#              (may have spaces in the path so use it within quotes)
# 

function indent() {
    width=$1
    file=$2
    cat "${file}" | awk "{ printf(\"%${width}s%s\n\", \" \", \$0) }"
}

function compile() {
    output=$(javac "$1" 2>&1)
    if [ $? -eq 0 ]; then
        echo '<span class="compiler ok">OK</span> Compiled successfully' >> "${RESULT}"
        return 0
    else
        echo '<span class="compiler nok">X</span> There were errors.' >> "${RESULT}"
        echo '<div class="run-listing">' >> "${RESULT}"
        echo "" >> "${RESULT}"
        echo '```plaintext' >> "${RESULT}"
        echo "$output" >> "${RESULT}"
        echo '```' >> "${RESULT}"
        echo "" >> "${RESULT}"
        echo "</div>" >> "${RESULT}"
        echo "" >> "${RESULT}"
        return 1
    fi
}

function renderCode() {
    echo "$(cat "$1" | pygmentize -l java -f html -O "style=autumn,linenos=inline,wrapcode,noclasses")" >> "${RESULT}"
    echo "" >> "${RESULT}"
}

function processUmlDiagram() {
    # To use this, the grader needs to inject "<!-- UML-INJECT -->" into the
    # markdown file where you want the uml diagram to be injected.

    echo "" > uml.html

    # find plantuml files and convert them to svg
    for uml in $(find . -name \*uml -o -name \*.pu | grep -v __MACOSX); do 
        echo "Found PlantUML file: ${uml}"
        svg=$(basename $uml).svg
        curl -s https://www.plantuml.com/plantuml/svg/$(${SCRIPTDIR}/plantuml-encode "${uml}") > "${svg}"    
        cat <<EOHTML >> uml.html
            <h3>$(basename $uml)</h3>
            $(cat ${svg})
EOHTML
        rm ${svg}
    done

    # Find any other image files (png, jpg, jpeg, gif)
    for img in $(find . -name \*.png -o -name \*.jpg -o -name \*.jpeg -o -name \*.gif); do
        echo "Found image file: ${img}"
        cat <<EOHTML >> uml.html
            <img class="uml" src="${img}"/>
EOHTML
    done

    for pdf in $(find . -name \*.pdf | grep -v feedback); do 
        echo "Found pdf file: ${pdf}"
        cleanpdf=$(echo "$pdf" | sed 's/^\.\///' | sed 's/ /+/')
        cat <<EOHTML >> uml.html
            <p class="uml">
            <b>${pdf}</b>: 
            <em>Please review this file separately as it cannot be rendered in this document.</em>
            </p>
EOHTML
    done
}


export IFS=$'\n'

export SCRIPTDIR=$(dirname $0)
export HTML_EXTRA="extra.html"

zip=$1

userdir=$(echo "${zip}" | sed 's/_/ /' | awk '{ print $1; }')
echo ${userdir}
if [ ! -d "${userdir}" ]; then
    unzip -qq -o -d ${userdir} "${zip}"
fi

pushd ${userdir} > /dev/null
dir=$(pwd)
if [ "${HAS_UML_DIAGRAM}" == "1" ]; then
    # Look for any PDF files outside of our directory and copy them in.
    for pdf in $(ls ../${userdir}*.pdf 2> /dev/null); do
        echo "Copying $pdf into working directory"
        cp $pdf .
    done
fi


# create the file or clear out the file if it exists.
RESULT="`pwd`/${userdir}.feedback.md"
echo "" > "${RESULT}"
echo '<div id="submitter">' >> "${RESULT}"
echo "<label>Submitter:</label>${userdir}<br/>" >> "${RESULT}"
echo "<label>Run date:</label> $(date "+%b %d, %Y")" >> "${RESULT}"
echo '</div>' >> "${RESULT}"
echo "" >> "${RESULT}"

echo "${RESULT_TITLE}" >> "${RESULT}"
echo "===" >> "${RESULT}"

if [ "${HAS_USERDIR_HOOK}" != "" ]; then
    onUserDir "${userdir}"
fi

# clear out class files
find . -name \*.class -exec rm {} \;

let moduleCounter=0

for module in ${JAVA_MODULES[*]}; do 

    export module
    
    export javaPath=$(find . -name ${module}.java)
    if [ "${javaPath}" != "" ]; then
    
        let moduleCounter=($moduleCounter + 1)

        echo "Found ${javaPath}"
        echo "## ${moduleCounter} $(basename ${javaPath})" >> "${RESULT}"
        
        export submissionDir="$(pwd)"
        export javaDir="$(dirname ${javaPath})"
        pushd "${javaDir}" > /dev/null

        export javaFile=$(basename "${javaPath}")

        if [ "$NO_COMPILE" == "" ]; then
        
            # Remove package, if any
            for jj in $(ls *.java); do
                cp ${jj} tmpfile
                cat tmpfile | perl -p -e 's/^\s*package .*;//g' > $jj
                rm tmpfile
            done

            # Compile the file
            echo "### ${moduleCounter}.1 Compile Program" >> "${RESULT}"
            compile "${javaFile}"
            if [ $? -eq 0 ]; then
                echo "### ${moduleCounter}.2 Run Program" >> "${RESULT}"
                echo '<div class="run-listing">' >> "${RESULT}"
                echo "" >> "${RESULT}"
                export javaClass=$(echo ${javaFile} | sed 's/\.java//')

                # Run the class
                gradeModule
                echo "" >> "${RESULT}"
                echo '</div>' >> "${RESULT}"
                echo "" >> "${RESULT}"
            fi
        fi

        popd > /dev/null

        # Add source code to result file
        echo "### ${moduleCounter}.3 Source Listing" >> "${RESULT}"
        renderCode "${javaPath}"
    fi
done

if [[ $moduleCounter -eq 0 ]]; then
    echo "" >> "${RESULT}"
    echo '<div class="missing-everything">Expected to find files named according to the assignment instructions, but did not find any matching files.</div>' >> "${RESULT}"
    echo "" >> "${RESULT}"
fi

# Find any other Java files that were not part of the modules
let fileCount=0
for javaFile in $(find . -name "*.java" | grep -vi __macosx); do
    className=$(basename $javaFile | sed 's/\.java//')
    if [[ ! " ${JAVA_MODULES[@]} " =~ " ${className} " ]]; then
        echo "Found $javaFile"
        if [[ $fileCount -eq 0 ]]; then
            let moduleCounter=($moduleCounter+1)
            echo "# $moduleCounter Unexpected Java Files" >> "${RESULT}"
        fi
        let fileCount=($fileCount+1)
        echo "## ${moduleCounter}.${fileCount} ${className}.java" >> "${RESULT}"
        echo "" >> "${RESULT}"
        echo "**Location:** ${javaFile}" >> "${RESULT}"
        echo "" >> "${RESULT}"
        renderCode "${javaPath}"
        pushd "$(dirname $javaFile)" > /dev/null
        compile "$(basename $javaFile)"
        popd > /dev/null
    fi
done

if [ "${HAS_FINISHED_HOOK}" != "" ]; then
    onFinished
fi

cat <<EOF > header.html
<html><head>
<style type="text/css">
body { font-family: sans-serif; }
pre { padding: .5em; overflow-wrap: break-word; 
      white-space: pre-wrap; page-break-before: avoid !important; }
td { vertical-align: top; }
h1 { page-break-before: always }
h1:first-of-type, .missing-everything+h1 { page-break-before: avoid; }
h2 { page-break-before: always; 
     border-bottom: 2px solid #000; padding-bottom: .5em;}
h1+h2 { page-break-before: avoid; }
h3 { border-bottom: 1px solid #999; }
h3, h4, h5, h6 { margin-top: 3em; }
.uml { font-size: smaller; }
#submitter { float: right; box-shadow: 2px 2px 4px #222; border: 1px solid #000; 
             border-radius: 5px; padding: .5em .75em; }
#submitter label { font-weight: bold; margin-right: 2em; }
.compiler { font-size: larger; font-weight: bold; }
.compiler.nok { color: #ff0000; }
.compiler.ok { color: #00aa00; }
.run-listing pre { background-color: #242424; 
                   color: #dddddd; padding: 1.25em; border-radius: 5px; }
.missing-everything { background-color: #f9cccc; color: #ff0000; 
                      margin: 3em 0; padding: 1em; border-radius: .25em; }

</style>
</head>
<body>
EOF

markdown-it "${RESULT}" > content.html

if [ "${HAS_HTML_EXTRA}" != "" ]; then
    cat "${HTML_EXTRA}" >> content.html
    rm "${HTML_EXTRA}"
fi

echo "</body></html>" >> content.html

cat header.html content.html > "${userdir}.feedback.html"

if [ "${HAS_UML_DIAGRAM}" == "1" ]; then
    processUmlDiagram
    sed -i "" -e '/<!-- UML-INJECT -->/r uml.html' "${userdir}.feedback.html"
    rm uml.html
fi

if [ "${HAS_HTML_POST_RENDER_HOOK}" == "1" ]; then
    doHtmlPostRender "${userdir}.feedback.html"
fi

wkhtmltopdf -q "${userdir}.feedback.html" "${userdir}.feedback.pdf"

rm content.html header.html "${userdir}.feedback.html" "${RESULT}"

popd > /dev/null
