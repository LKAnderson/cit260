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

for module in A4dot12 A4dot23; do 
    
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
            A4dot12)
                echo "Expect: 0 should be 0000" >> "${RESULT}"; echo "0" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 1 should be 0001" >> "${RESULT}"; echo "1" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 2 should be 0010" >> "${RESULT}"; echo "2" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 3 should be 0011" >> "${RESULT}"; echo "3" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 4 should be 0100" >> "${RESULT}"; echo "4" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 5 should be 0101" >> "${RESULT}"; echo "5" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 6 should be 0110" >> "${RESULT}"; echo "6" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 7 should be 0111" >> "${RESULT}"; echo "7" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 8 should be 1000" >> "${RESULT}"; echo "8" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: 9 should be 1001" >> "${RESULT}"; echo "9" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: A should be 1010" >> "${RESULT}"; echo "A" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: B should be 1011" >> "${RESULT}"; echo "B" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: C should be 1100" >> "${RESULT}"; echo "C" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: D should be 1101" >> "${RESULT}"; echo "D" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: E should be 1110" >> "${RESULT}"; echo "E" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: F should be 1111" >> "${RESULT}"; echo "F" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: T should be invalid" >> "${RESULT}"; echo "T" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                echo "Expect: <blank> should be invalid" >> "${RESULT}"; echo "" | java $javaClass >> "${RESULT}" 2>&1; printf "\n\n" >> "${RESULT}"
                printf "\n\n\n" >> "${RESULT}"
                ;;

            A4dot23)
                echo "Employee:    Smith" >> "${RESULT}"
                echo "Hours worked:   40" >> "${RESULT}"
                echo "Hourly rate:    25" >> "${RESULT}"
                echo "Federal rate:  .15" >> "${RESULT}"
                echo "State rate:    .07" >> "${RESULT}"
                printf "\n\n" >> "${RESULT}"
                printf "Smith\n40\n25\n.15\n.07" | java $javaClass >> "${RESULT}" 2>&1
                
                printf "\n\nNow with invalid inputs...\n\n" >> "${RESULT}"
                echo "Employee:    Smith" >> "${RESULT}"
                echo "Hours worked:   -1" >> "${RESULT}"
                echo "Hourly rate:    -1" >> "${RESULT}"
                echo "Federal rate:   -1" >> "${RESULT}"
                echo "State rate:     -1" >> "${RESULT}"
                printf "\n\n" >> "${RESULT}"
                printf "Smith\n-1\n-1\n-1\n-1" | java $javaClass >> "${RESULT}" 2>&1
                ;;
        esac
        popd > /dev/null
    fi
done

popd > /dev/null
