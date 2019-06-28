#!/usr/bin/env bash

export JAVA_MODULES=(MyPoint A10dot4)

function gradeModule() {

    case $module in

    A10dot4)
        java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        ;;

    esac
}

source $(dirname $0)/autograder_driver.sh