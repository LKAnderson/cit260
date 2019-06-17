#!/usr/bin/env bash

export IFS=$'\n'

zip=$1

dir=$(echo "$zip" | sed 's/_/ /' | awk '{ print $1; }')
unzip -qq -o -d $dir $zip

pushd $dir > /dev/null
dir=$(pwd)

# clear out class files
find . -name \*.class -exec rm {} \;

javaPath=$(find . -name A9dot\*1.java)
if [ $javaPath != "" ]; then
    echo "Found ${javaPath}"

    javaDir=$(dirname "${javaPath}")
    pushd "${javaDir}" > /dev/null

    javaFile=$(basename ${javaPath})

    # Remove package, if any
    for jj in $(ls *.java); do
        cp $jj tmpfile
        cat tmpfile | sed 's/^\s*package .*;//' > $jj
        rm tmpfile
    done

    mkdir -p "${dir}/RESULT/"
    RESULT="${dir}/result/9.1.txt"
    echo "A9dot1" > "${RESULT}"
    echo "------" >> "${RESULT}"


    # Compile the file
    echo "Compiling it"
    echo "Compile A9dot1" >> "${RESULT}"
    javac $javaFile 2>> "${RESULT}"
    echo "--------------" >> "${RESULT}"

    # Check for cheating
    echo -n "Cheating Check: A9dot1: " >> "${RESULT}"
    echo -n "$(is_copy $javaFile $HOME/Projects/Intro-to-Java-Programming/Exercise_09/Exercise_09_01/Exercise_09_01.java)%, Rectangle: " >> ${RESULT}
    echo "$(is_copy Rectangle.java $HOME/Projects/Intro-to-Java-Programming/Exercise_09/Exercise_09_01/Rectangle.java)%" >> ${RESULT}
    echo "--------------------" >> "${RESULT}"

    javaClass=$(echo $javaFile | sed 's/\.java//')

    # Run the class
    echo "Running it"
    echo "Output" >> "${RESULT}"
    java $javaClass 2>&1 >> "${RESULT}"
    echo "" >> "${RESULT}"

    echo "-------------" >> "${RESULT}"
    echo "Looking for elements" >> "${RESULT}"

    count=$(cat ${RESULT} | grep -e '160\.0' | wc | awk '{print $1;}')
    echo "160.0: $count" >> "${RESULT}"

    count=$(cat ${RESULT} | grep -e '88\.0' | wc | awk '{print $1;}')
    echo "88.0: $count" >> "${RESULT}"

    count=$(cat ${RESULT} | grep -e '125\.[67]' | wc | awk '{print $1;}')
    echo "125.65: $count" >> "${RESULT}"

    count=$(cat ${RESULT} | grep -e '78\.8' | wc | awk '{print $1;}')
    echo "78.8: $count" >> "${RESULT}"

    popd > /dev/null
fi

javaPath=$(find . -name A9dot\*3.java)
if [ $javaPath != "." ]; then
    echo "Found ${javaPath}"
    javaDir=$(dirname "${javaPath}")
    pushd "${javaDir}" > /dev/null

    javaFile=$(basename ${javaPath})

    # Remove package, if any
    for jj in $(ls *.java); do
        cp $jj tmpfile
        cat tmpfile | sed 's/^\s*package .*;//' > $jj
        rm tmpfile
    done

    mkdir -p "${dir}/RESULT/"
    RESULT="${dir}/result/9.3.txt"
    echo "A9dot3" > "${RESULT}"
    echo "------" >> "${RESULT}"


    # Compile the file
    echo "Compiling it"
    echo "Compile A9dot3" >> "${RESULT}"
    javac $javaFile 2>> "${RESULT}"
    echo "--------------" >> "${RESULT}"

    # Check for cheating
    echo -n "Cheating Check: " >> "${RESULT}"
    echo "$(is_copy $javaFile $HOME/Projects/Intro-to-Java-Programming/Exercise_09/Exercise_09_03/Exercise_09_03.java)%" >> ${RESULT}
    echo "--------------------" >> "${RESULT}"

    javaClass=$(echo $javaFile | sed 's/\.java//')

    # Run the class
    echo "Running it"
    echo "Output" >> "${RESULT}"
    java $javaClass 2>&1 >> "${RESULT}"
    echo "" >> "${RESULT}"

    echo "-------------" >> "${RESULT}"
    echo "Looking for elements" >> "${RESULT}"

    echo -n "Number of times 'new Date' is called: " >> "${RESULT}"
    echo "$(cat $javaFile | grep -e 'new\s\+Date' | wc | awk '{print $1;}')" >> "${RESULT}"

    echo -n "Number of times 'setTime' is called: " >> "${RESULT}"
    echo "$(cat $javaFile | grep -e 'setTime\s*(' | wc | awk '{print $1;}')" >> "${RESULT}"

    echo -n "Number of times 'while' is used: " >> "${RESULT}"
    echo "$(cat $javaFile | grep -e 'while' | wc | awk '{print $1;}')" >> "${RESULT}"

    echo -n "Number of times 'for' is called: " >> "${RESULT}"
    echo "$(cat $javaFile | grep -e 'for\s*(' | wc | awk '{print $1;}')" >> "${RESULT}"
    
    popd > /dev/null
fi

popd > /dev/null
