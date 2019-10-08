#!/usr/bin/env bash

export JAVA_MODULES=(W2dot1 w2dot1 W2dot2 w2dot2)

function gradeModule() {
    
    case $module in 
        W2dot1|w2dot1)
            printf "43.5\n" | java $module >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            printf "45.0\n" | java $module >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            printf "100\n" | java $module >> "${RESULT}" 2>&1 
            printf "\n\n" >> "${RESULT}"
            printf "100.0123\n" | java $module >> "${RESULT}" 2>&1
            printf "\n\n" >> ${RESULT}
            printf "23.0\n" | java $module >> "${RESULT}" 2>&1 
            printf "\n\n" >> "${RESULT}"
            ;;

        W2dot2|w2dot2)
            printf "12.50\n15\n" | java $module >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            printf "20\n18\n" | java $module >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh