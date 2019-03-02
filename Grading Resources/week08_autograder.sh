#!/usr/bin/env bash

export IFS=$'\n'

for zip in $(ls *.zip); do

    dir=$(echo "$zip" | sed 's/.zip//')
    unzip -qq -o -d $dir $zip
    
    echo $dir
    pushd $dir > /dev/null


    # clear out class files
    find . -name \*.class -exec rm {} \;

    # find java files
    for javaPath in $(find . -name \*.java); do
        javaDir=$(dirname $javaPath)
        javaFile=$(basename $javaPath)
        
        pushd $javaDir > /dev/null

        # Remove any package names.
        indent="   "
        echo $indent $javaFile
        cp $javaFile tmpfile
        cat tmpfile | sed 's/^\s*package .*;//' > $javaFile
        rm tmpfile

        # Compile the file
        javac $javaFile 2> $javaFile.compile.txt
        if [ "$?" != "0" ]; then
            echo $indent $javaFile has errors
        else
            class=$(echo $javaFile | sed 's/.java//')
            echo "1 2 3 4 5 6 7 8 9 10" | java $class 2>&1 > $class.result.txt
        fi

        # Check for cheating
        
        if [ $class == "A7dot8" ]; then
            touch ${class}_match_$(is_copy $javaFile $HOME/Projects/Intro-to-Java-Programming/Exercise_07/Exercise_07_08/Exercise_07_08.java)
        fi  

        if [ $class == "A7dot11" ]; then
            touch ${class}_match_$(is_copy $javaFile $HOME/Projects/Intro-to-Java-Programming/Exercise_07/Exercise_07_11/Exercise_07_11.java)
        fi  

        popd > /dev/null

    done

    popd > /dev/null
    

done