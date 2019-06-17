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

for module in A3dot5 A3dot11; do 
    
    echo "===== ${module} =====" >> ${RESULT}

    javaPath=$(find . -name ${module}.java)
    if [ $javaPath != "" ]; then
    
        echo "Found ${javaPath}"

        
        submissionDir=$(pwd)
        javaDir=$(dirname "${javaPath}")
        pushd "${javaDir}" > /dev/null

        javaFile=$(basename ${javaPath})

        # Print the file to PDF
        enscript -1jC --font=Courier@7 -q --color -T 4 -E -p - "$javaFile" | pstopdf -o "${submissionDir}/${javaFile}.pdf"


        # Remove package, if any
        for jj in $(ls *.java); do
            cp $jj tmpfile
            cat tmpfile | perl -p -e 's/^\s*package .*;//g' > $jj
            #cat tmpfile | iconv -t ISO-8859-1 | LC_ALL=C sed 's/^\s*package .*;//' > $jj
            rm tmpfile
        done

        # Compile the file
        echo "Compile ${javaPath}" >> "${RESULT}"
        javac $javaFile 2>> "${RESULT}"
        echo "--------------" >> "${RESULT}"

        javaClass=$(echo $javaFile | sed 's/\.java//')

        # Run the class
        case $module in 
            A3dot5)
                echo "Output 0-Sunday -> 3-Wednesday" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "0 3" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output 0-Sunday -> 15-Monday" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "0 15" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output -1 Invalid" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "-1 -2" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output 7 Invalid" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "7 -2" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                ;;

            A3dot11)
                echo "Output 1 2019 -> 31 days" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "1 2019" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output 2 2019 -> 28 days" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "2 2019" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output 4 2016 -> 30 days" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "4 2016" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output 2 2000 -> 29 days" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "2 2000" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output 2 1900 -> 28 days" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "2 1900" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output -1 2020 -> Invalid" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "-1 2020" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                echo "Output 13 2020 -> Invalid" >> "${RESULT}"
                echo -n " ===> " >> "${RESULT}"
                echo "13 2020" | java $javaClass >> "${RESULT}" 2>&1
                echo "" >> "${RESULT}"
                ;;
        esac
        popd > /dev/null
    fi
done

popd > /dev/null
