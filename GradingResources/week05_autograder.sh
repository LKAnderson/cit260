#!/usr/bin/env bash

export IFS=$'\n'

zip=$1

userdir=$(echo "$zip" | sed 's/_/ /' | awk '{ print $1; }')
echo ${userdir}
if [ ! -d "$userdir" ]; then
    unzip -qq -o -d $userdir "$zip"
fi

pushd $userdir > /dev/null
dir=$(pwd)

# clear out class files
find . -name \*.class -exec rm {} \;


RESULT="`pwd`/${userdir}_RESULT.txt"

# create the file or clear out the file if it exists.
echo -n "" > ${RESULT}

for module in A5dot3 A5dot10; do 
    
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
            rm tmpfile
        done

        # Compile the file
        echo "Compile ${javaPath}" >> "${RESULT}"
        javac $javaFile 2>> "${RESULT}"
        echo "--------------" >> "${RESULT}"

        javaClass=$(echo $javaFile | sed 's/\.java//')

        # Run the class
        case $module in 
            A5dot3)
                java $javaClass >> "${RESULT}" 2>&1; 
                printf "\n\n\n" >> "${RESULT}"
                ;;

            A5dot10)
                java $javaClass >> "${RESULT}" 2>&1
                printf "\n\n" >> "${RESULT}"
                ;;
        esac
        popd > /dev/null
    fi
done

popd > /dev/null
