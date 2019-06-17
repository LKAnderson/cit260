#!/usr/bin/env bash

export JAVA_MODULES=(Rectangle A9dot1 A9dot3)

function gradeModule() {

    case $module in

    A9dot1)
        java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        ;;

    A9dot3)
        java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        ;;

    esac

    printf "\n\n\n\n" >> "${RESULT}"
    
}

source $(dirname $0)/autograder_driver.sh