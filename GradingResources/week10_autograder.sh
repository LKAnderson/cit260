#!/usr/bin/env bash

export JAVA_MODULES=(GeometricObject Triangle triangle A11dot1 A11Dot1)

function gradeModule() {

    case $module in

    A11dot1)
        echo "4 5 6 NavyBlue true" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        ;;
    A11Dot1)
        echo "4 5 6 NavyBlue true" | java $javaClass >> "${RESULT}" 2>&1
        echo "" >> "${RESULT}"
        ;;

    esac
}

source $(dirname $0)/autograder_driver.sh
