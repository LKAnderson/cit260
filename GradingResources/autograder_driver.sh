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

export IFS=$'\n'

zip=$1

userdir=$(echo "${zip}" | sed 's/_/ /' | awk '{ print $1; }')
echo ${userdir}
if [ ! -d "${userdir}" ]; then
    unzip -qq -o -d ${userdir} "${zip}"
fi

pushd ${userdir} > /dev/null
dir=$(pwd)

# clear out class files
find . -name \*.class -exec rm {} \;

RESULT="`pwd`/${userdir}_RESULT.txt"

# create the file or clear out the file if it exists.
echo -n "" > ${RESULT}

PDFFILES=("${RESULT}")

for module in ${JAVA_MODULES[*]}; do 

    export module
    
    export javaPath=$(find . -name ${module}.java)
    if [ "${javaPath}" != "" ]; then
    
        echo "Found ${javaPath}"
        echo "=================================================== ${module} =====" >> ${RESULT}
        
        export submissionDir="$(pwd)"
        export javaDir="$(dirname ${javaPath})"
        pushd "${javaDir}" > /dev/null

        export javaFile=$(basename "${javaPath}")

        # Add the file to the list of PDFs
        PDFFILES+=("${javaPath}")

        # Remove package, if any
        for jj in $(ls *.java); do
            cp ${jj} tmpfile
            cat tmpfile | perl -p -e 's/^\s*package .*;//g' > $jj
            rm tmpfile
        done

        # Compile the file
        echo "Compile ${javaPath}" >> "${RESULT}"
        javac ${javaFile} 2>> "${RESULT}"
        echo "" >> "${RESULT}"
        echo "------- Run it -------" >> "${RESULT}"

        export javaClass=$(echo ${javaFile} | sed 's/\.java//')

        # Run the class
        gradeModule
        
        echo "" >> "${RESULT}"

        popd > /dev/null
    fi
done

FEEDBACKFILE="${userdir}.feedback"
enscript -1jC --font=Courier@7 -q --color -T 4 -E -p - "${PDFFILES[@]}" > "${FEEDBACKFILE}.ps"
bash -c "ps2pdf ${FEEDBACKFILE}.ps ${FEEDBACKFILE}.pdf"
rm "${FEEDBACKFILE}.ps"

popd > /dev/null
