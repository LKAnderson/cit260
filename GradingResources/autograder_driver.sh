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

indent() {
    width=$1
    file=$2
    cat "${file}" | awk "{ printf(\"%${width}s%s\n\", \" \", \$0) }"
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
if [ "${HAS_USERDIR_HOOK}" != "" ]; then
    onUserDir "${userdir}"
fi

# clear out class files
find . -name \*.class -exec rm {} \;

RESULT="`pwd`/${userdir}.feedback.md"

# create the file or clear out the file if it exists.
echo "${RESULT_TITLE}" > "${RESULT}"
echo "===" >> "${RESULT}"

for module in ${JAVA_MODULES[*]}; do 

    export module
    
    export javaPath=$(find . -name ${module}.java)
    if [ "${javaPath}" != "" ]; then
    
        echo "Found ${javaPath}"
        echo "## ${module}" >> "${RESULT}"
        
        export submissionDir="$(pwd)"
        export javaDir="$(dirname ${javaPath})"
        pushd "${javaDir}" > /dev/null

        export javaFile=$(basename "${javaPath}")

        # Remove package, if any
        for jj in $(ls *.java); do
            cp ${jj} tmpfile
            cat tmpfile | perl -p -e 's/^\s*package .*;//g' > $jj
            rm tmpfile
        done

        # Compile the file
        echo "### Compiling ${javaPath}" >> "${RESULT}"
        echo '```plaintext' >> "${RESULT}"
        javac ${javaFile} 2>> "${RESULT}"
        if [ $? -eq 0 ]; then
            echo "Compiled cleanly" >> "${RESULT}"
        fi
        echo '```' >> "${RESULT}"

        echo "### Running ${javaPath}" >> "${RESULT}"

        export javaClass=$(echo ${javaFile} | sed 's/\.java//')

        # Run the class
        gradeModule
        echo "" >> "${RESULT}"

        popd > /dev/null

        # Add source code to result file
        echo "### ${module} Source Listing" >> "${RESULT}"
        echo '```java' >> "${RESULT}"
        cat "${javaPath}" >> "${RESULT}"
        echo "" >> "${RESULT}"; echo '```' >> "${RESULT}"
    fi
done

cat <<EOF > header.html
<html><head>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.15.10/styles/tomorrow.min.css">
<style type="text/css">
body { font-family: sans-serif; }
pre { border: 1px solid black; padding: .5em; overflow-wrap: break-word; page-break-before: avoid; }
td { vertical-align: top; }
h2 { page-break-before: always; }
h2:first-of-type { page-break-before: avoid; }
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.15.10/highlight.min.js"></script>
<script>hljs.initHighlightingOnLoad();</script>
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

wkhtmltopdf -q "${userdir}.feedback.html" "${userdir}.feedback.pdf"

rm content.html header.html "${userdir}.feedback.html"

popd > /dev/null
