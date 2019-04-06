#!/usr/bin/env bash

export IFS=$'\n'

zip=$1

dir=$(echo "$zip" | sed 's/_/ /' | awk '{ print $1; }')
unzip -qq -o -d $dir $zip

pushd $dir > /dev/null
dir=$(pwd)

# clear out class files
find . -name \*.class -exec rm {} \;

javaPath=$(find . -name A11dot\*1.java)
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
    RESULT="${dir}/result/11.1.txt"
    echo "A11dot1" > "${RESULT}"
    echo "------" >> "${RESULT}"


    # Compile the file
    echo "Compiling it"
    echo "Compile A11dot1" >> "${RESULT}"
    javac $javaFile 2>> "${RESULT}"
    echo "--------------" >> "${RESULT}"


    # Run the class
    javaClass=$(echo $javaFile | sed 's/\.java//')
    echo "Running it"
    echo "Output" >> "${RESULT}"
    echo "4 5 6 NavyBlue true" | java $javaClass 2>&1 >> "${RESULT}"
    echo "" >> "${RESULT}"
    echo "Error Output" >> "${RESULT}"
    echo "4 -5 6 White false" | java $javaClass 2>&1 >> "${RESULT}"
    echo "" >> "${RESULT}"

    echo "-------------" >> "${RESULT}"

    popd > /dev/null
fi

popd > /dev/null
