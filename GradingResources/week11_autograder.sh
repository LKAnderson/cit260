#!/usr/bin/env bash

export JAVA_MODULES=$(for f in $(ls -R | grep .java | grep -v pdf | sort -u); do echo "${f%.*}"; done)

#export JAVA_MODULES=(A12dot2 A12Dot2 A12dot3 A12Dot3 PromptUser Errors UserInput A12dqot3 Exception inputs)

function gradeModule() {

    case $module in

    A12dot2|A12Dot2)
        echo "INPUTS: 20 + 30 should equal 50" >> "${RESULT}"
        printf "20\n30\n" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        echo "INPUTS: a + b should produce an error" >> "${RESULT}"
        printf "a\nb\n" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        ;;
    A12dot3|A12Dot3|A12dqot3)
        echo "INPUT: 15 (should return a valid value)" >> "${RESULT}"
        printf "15\n" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        echo "INPUT: 85 (should return a valid value)" >> "${RESULT}"
        printf "85\n" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        echo "INPUT: -1 (should cause an error)" >> "${RESULT}"
        echo "-1" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        echo "INPUT: 100 (should cause an error)" >> "${RESULT}"
        printf "100\n" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        echo "INPUT: 500 (should cause an error)" >> "${RESULT}"
        printf "500\n" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        ;;

    esac
}

source $(dirname $0)/autograder_driver.sh
