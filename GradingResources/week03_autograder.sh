#!/usr/bin/env bash


export RESULT_TITLE="WEEK 3 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W3dot1 w3dot1 W3dot2 w3dot2)

function gradeModule() {
    case $module in 
        W3dot1|w3dot1)
            echo "### Case 1: 0-Sunday -> 3-Wednesday" >> "${RESULT}"
            printf "0\n3\n" | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"
            
            echo "### Case 2: 0-Sunday -> 15-Monday" >> "${RESULT}"
            printf "0\n15\n" | java -Djava.security.manager $module  >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"

            echo "### Case 3: 5-Friday -> 21-Friday" >> "${RESULT}"
            printf "5\n21\n" | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"
            
            echo "### Case 4: 5 -1 Invalid" >> "${RESULT}"
            printf '%d\n%d\n' 5 -1 | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"

            echo "### Case 5: 7 -2 Invalid" >> "${RESULT}"
            printf '%d\n\%d\n' 7 -2 | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"
            ;;

        W3dot2|w3dot2)
            echo "### Case 1: 2019 1 -> 31 days" >> "${RESULT}"
            printf "2019\n1\n" | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"
            
            echo "### Case 2: 2019 2 -> 28 days" >> "${RESULT}"
            printf "2019\n2\n" | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"
            
            echo "### Case 3: 2016 4 -> 30 days" >> "${RESULT}"
            printf "2016\n4\n" | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"

            echo "### Case 4: 2000  2 -> 29 days" >> "${RESULT}"
            printf "2000\n2\n" | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"

            echo "### Case 5: 1900 2 -> 28 days" >> "${RESULT}"
            printf "1900\n2\n" | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"

            echo "### Case 6: 2020 -1 -> Invalid" >> "${RESULT}"
            printf "%d\n%d\n" 2020 -1 | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"

            echo "### Case 7: 2020 13 -> Invalid" >> "${RESULT}"
            printf "2020\n13\n" | java -Djava.security.manager $module >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"
            rm "$$"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh