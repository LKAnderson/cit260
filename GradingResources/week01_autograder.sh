#!/usr/bin/env bash

export IFS=$'\n'

zip=$1

dir=$(echo "$zip" | sed 's/_/ /' | awk '{ print $1; }')
echo ${dir}
unzip -qq -o -d $dir "$zip"

pushd $dir > /dev/null
dir=$(pwd)

# clear out class files
find . -name \*.class -exec rm {} \;


RESULT="`pwd`/RESULT.txt"

# create the file or clear out the file if it exists.
echo -n "" > ${RESULT}

for module in A1dot1 A1dot2 A1dot3; do 
    
    echo "===== ${module} =====" >> ${RESULT}

    javaPath=$(find . -name ${module}.java)
    if [ $javaPath != "" ]; then
        echo "Found ${javaPath}"

        # Print the file to PDF
        enscript -2rjC -q --color -T 4 -E -p - "$javaPath" | pstopdf -o "${javaPath}.pdf"

        javaDir=$(dirname "${javaPath}")
        pushd "${javaDir}" > /dev/null

        javaFile=$(basename ${javaPath})

        # Remove package, if any
        for jj in $(ls *.java); do
            cp $jj tmpfile
            cat tmpfile | sed 's/^\s*package .*;//' > $jj
            rm tmpfile
        done

        # Compile the file
        echo "Compile ${javaPath}" >> "${RESULT}"
        javac $javaFile 2>> "${RESULT}"
        echo "--------------" >> "${RESULT}"

        javaClass=$(echo $javaFile | sed 's/\.java//')

        # Run the class
        echo "Output" >> "${RESULT}"
        java $javaClass 2>&1 >> "${RESULT}"
        echo "" >> "${RESULT}"

        popd > /dev/null
    fi
done

popd > /dev/null
