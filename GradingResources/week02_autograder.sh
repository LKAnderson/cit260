#!/usr/bin/env bash

export IFS=$'\n'

zip=$1

dir=$(echo "$zip" | sed 's/_/ /' | awk '{ print $1; }')
echo ${dir}
if [ ! -d "$dir" ]; then
    unzip -qq -o -d $dir "$zip"
fi

pushd $dir > /dev/null
dir=$(pwd)

# clear out class files
find . -name \*.class -exec rm {} \;


RESULT="`pwd`/RESULT.txt"

# create the file or clear out the file if it exists.
echo -n "" > ${RESULT}

for module in A2dot1 A2dot2 A2dot5; do 
    
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
        case $module in 
            A2dot1)
                echo "Output (30.5 C should be 86.9 F)" >> "${RESULT}"
                echo -n "===> " >> "${RESULT}"
                echo "30.5" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                ;;

            A2dot2)
                echo "Output (r=15, h=10; should be 706.86 and 7068.58)" >> "${RESULT}"
                echo -n "===> " >> "${RESULT}"
                echo "15 10" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                ;;

            A2dot5)
                echo "Output (\$100.00 and 15% should be 115.00 )" >> "${RESULT}"
                echo -n "===> " >> "${RESULT}"
                echo "100 15" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                ;;

        esac
        popd > /dev/null
    fi
done

popd > /dev/null
