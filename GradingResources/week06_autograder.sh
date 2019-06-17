#!/usr/bin/env bash

export JAVA_MODULES=(A6dot7 A6dot8)

function gradeModule() {
    # Run the class
    case $module in 
        A6dot7)
            printf "1000\n9\n" | java $javaClass >> "${RESULT}" 2>&1; 
            printf "\n\n\n" >> "${RESULT}"
            ;;

        A6dot8)
            java $javaClass >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh