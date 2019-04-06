#!/usr/bin/env bash

export IFS=$'\n'

zip=$1

dir=$(echo "$zip" | sed 's/_/ /' | awk '{ print $1; }')
unzip -qq -o -d $dir $zip

pushd $dir > /dev/null
dir=$(pwd)

# clear out class files
find . -name \*.class -exec rm {} \;

javaPath=$(find . -name A7dot\*8.java)
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
    RESULT="${dir}/result/7.8.txt"
    echo "A7dot8" > "${RESULT}"
    echo "------" >> "${RESULT}"


    # Compile the file
    echo "Compiling it"
    echo "Compile A7dot8" >> "${RESULT}"
    javac $javaFile 2>> "${RESULT}"
    echo "--------------" >> "${RESULT}"

    # Check for cheating
    echo -n "Cheating Check: A7dot8: " >> "${RESULT}"
    echo -n "$(is_copy $javaFile $HOME/Projects/Intro-to-Java-Programming/Exercise_07/Exercise_07_08/Exercise_07_08.java)%, Rectangle: " >> ${RESULT}
    echo "--------------------" >> "${RESULT}"

    javaClass=$(echo $javaFile | sed 's/\.java//')

    # Run the class
    echo "Running it"
    echo "Output" >> "${RESULT}"
    java $javaClass 2>&1 >> "${RESULT}"
    echo "" >> "${RESULT}"

    echo "-------------" >> "${RESULT}"
    echo "Looking for elements" >> "${RESULT}"

    popd > /dev/null
fi

javaPath=$(find . -name A7dot11.java)
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
    echo "A7dot11" > "${RESULT}"
    echo "------" >> "${RESULT}"


    # Compile the file
    echo "Compiling it"
    echo "Compile A7dot11" >> "${RESULT}"
    javac $javaFile 2>> "${RESULT}"
    echo "--------------" >> "${RESULT}"

    # Check for cheating
    echo -n "Cheating Check: " >> "${RESULT}"
    echo "$(is_copy $javaFile $HOME/Projects/Intro-to-Java-Programming/Exercise_07/Exercise_07_11/Exercise_07_11.java)%" >> ${RESULT}
    echo "--------------------" >> "${RESULT}"

    javaClass=$(echo $javaFile | sed 's/\.java//')

    # Run the class
    echo "Running it"
    echo "Output" >> "${RESULT}"
    java $javaClass 2>&1 >> "${RESULT}"
    echo "" >> "${RESULT}"

    echo "-------------" >> "${RESULT}"
    echo "Looking for elements" >> "${RESULT}"

    popd > /dev/null
fi

popd > /dev/null
