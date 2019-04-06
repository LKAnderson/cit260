#!/usr/bin/env bash

export IFS=$'\n'

zip=$1

dir=$(echo "$zip" | sed 's/_/ /' | awk '{ print $1; }')
unzip -qq -o -d $dir $zip

pushd $dir > /dev/null
dir=$(pwd)

# clear out class files
find . -name \*.class -exec rm {} \;

javaPath=$(find . -name A10dot\*4.java)
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
    RESULT="${dir}/result/10.4.txt"
    echo "A10dot4" > "${RESULT}"
    echo "------" >> "${RESULT}"


    # Compile the file
    echo "Compiling it"
    echo "Compile A10dot4" >> "${RESULT}"
    javac $javaFile 2>> "${RESULT}"
    echo "--------------" >> "${RESULT}"


    # Run the class
    javaClass=$(echo $javaFile | sed 's/\.java//')
    echo "Running it"
    echo "Output" >> "${RESULT}"
    java $javaClass 2>&1 >> "${RESULT}"
    echo "" >> "${RESULT}"

    echo "-------------" >> "${RESULT}"
    echo "Looking for elements" >> "${RESULT}"

    if [ -e MyPoint.java ]; then 
        echo "MyPoint.java exists" >> "${RESULT}"
    else 
        echo "MyPoint.java does not exist" >> "${RESULT}"
    fi

    echo "Looking for distance methods..." >> "${RESULT}"
    grep -e "distance\s*(" *.java >> "${RESULT}"

    popd > /dev/null
fi

popd > /dev/null
