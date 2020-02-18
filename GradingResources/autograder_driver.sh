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

function output() {
    echo "$*" >> "${RESULT}"
}

function compile() {
    coutput=$(javac "$1" 2>&1)
    if [ $? -eq 0 ]; then
        output '<span class="compiler ok">OK</span> Compiled successfully'
        return 0
    else
        output '<span class="compiler nok">X</span> There were errors.'
        output '<div class="run-listing">'
        output ""
        output '<pre>'
        output "$coutput"
        output '</pre>'
        output "</div>"
        return 1
    fi
}

function renderCode() {
    output $(cat "$1" | pygmentize -l java -f html -O "style=autumn,linenos=inline,wrapcode,noclasses")
}



function formattingDisclaimer() {
    output "<p><em>Do not worry about the formatting you see here. The auto-grader skips over"
    output "some of the extra newline characters as it processes your program.</em></p>"
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
    if [[ "$zip" == *.zip ]]; then 
        unzip -qq -o -d ${userdir} "${zip}"
    fi

    if [[ "$zip" == *.rar ]]; then
        cp "$zip" "$userdir.rar"
        open "$userdir.rar"
        rm "$userdir.rar"
    fi
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
RESULT="`pwd`/${userdir}.feedback.html"
cat <<EOF > "${RESULT}"
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
             border-radius: 5px; padding: .5em .75em; min-width: 25%;}
#submitter label { font-weight: bold; margin-right: 2em; }
div.highlight {
    border: 1px solid #000;
    border-radius: .25em;
    padding: 1em;
    margin-bottom: 1em;
    box-shadow: 2px 2px 4px #555;
}
.compiler { font-size: larger; font-weight: bold; }
.compiler.nok { color: #ff0000; }
.compiler.ok { color: #00aa00; }
.run-listing pre { background-color: #bbc; 
                   color: #000; padding: 1.25em; border-radius: 5px; 
                   font-size: larger; }

.missing-everything { background-color: #f9cccc; color: #ff0000; 
                      margin: 3em 0; padding: 1em; border-radius: .25em; }

</style>
</head>
<body>
EOF

output '<div id="submitter">'
output "<label>Submitter:</label>${userdir}<br/>"
output "<label>Run date:</label> $(date "+%b %d, %Y")"
output '</div>'
output ""

output "<h1>${RESULT_TITLE}</h1>"

if [ "${HAS_USERDIR_HOOK}" != "" ]; then
    onUserDir "${userdir}"
fi

# clear out class files
find . -name \*.class -exec rm {} \;

let moduleCounter=0

for module in ${JAVA_MODULES[*]}; do 

    export module
    
    export javaPath=$(find . -name ${module}.java | head -n 1)
    if [ "${javaPath}" != "" ]; then
    
        let moduleCounter=($moduleCounter + 1)

        echo "Found ${javaPath}"
        output "<h2>${moduleCounter} $(basename ${javaPath})</h2>"
        
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
            output "<h3>${moduleCounter}.1 Compile Program</h3>"
            compile "${javaFile}"
            if [ $? -eq 0 ]; then
                output "<h3>${moduleCounter}.2 Run Program</h3>"
                output '<div class="run-listing">'
                export javaClass=$(echo ${javaFile} | sed 's/\.java//')

                # Run the class
                gradeModule
                output '</div>'
            fi
        fi

        popd > /dev/null

        # Add source code to result file
        output "<h3>${moduleCounter}.3 Source Listing</h3>"
        renderCode "${javaPath}"
    fi
done

if [[ $moduleCounter -eq 0 ]]; then
    output ""
    output '<div class="missing-everything">Expected to find files named according to the assignment '
    output 'standard of W&lt;week#&gt;dot&lt;assignment#&gt;.java, but did not find any matching files.</div>'
    output ""
fi

# Find any other Java files that were not part of the modules
let fileCount=0
for javaFile in $(find . -type f -name "*.java" | grep -vi __macosx); do
    className=$(basename $javaFile | sed 's/\.java//')
    if [[ ! " ${JAVA_MODULES[@]} " =~ " ${className} " ]]; then
        echo "Found $javaFile"
        if [[ $fileCount -eq 0 ]]; then
            let moduleCounter=($moduleCounter+1)
            output "<h1>$moduleCounter Additional Java Files Found</h1>"
        fi
        let fileCount=($fileCount+1)
        output "<h2>${moduleCounter}.${fileCount} ${className}.java</h2>"
        output "<p><strong>Location:</strong> ${javaFile}</p>"
        renderCode "${javaFile}"
        pushd "$(dirname $javaFile)" > /dev/null
        compile "$(basename $javaFile)"
        popd > /dev/null
    fi
done

if [ "${HAS_FINISHED_HOOK}" != "" ]; then
    onFinished
fi

if [ "${HAS_HTML_EXTRA}" != "" ]; then
    output $(cat "${HTML_EXTRA}")
    rm "${HTML_EXTRA}"
fi

output "</body></html>"

if [ "${HAS_UML_DIAGRAM}" == "1" ]; then
    processUmlDiagram
    sed -i "" -e '/<!-- UML-INJECT -->/r uml.html' "${RESULT}"
    rm uml.html
fi

if [ "${HAS_HTML_POST_RENDER_HOOK}" == "1" ]; then
    doHtmlPostRender "${RESULT}"
fi

wkhtmltopdf -q "${userdir}.feedback.html" "${userdir}.feedback.pdf"

rm "${RESULT}"

popd > /dev/null
