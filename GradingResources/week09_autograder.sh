#!/usr/bin/env bash

export RESULT_TITLE="WEEK 9 PROGRAMMING EXERCISE"
export JAVA_MODULES=(W9dot1 w9dot1 W09dot1 MyPoint Mypoint mypoint)
export HAS_UML_DIAGRAM=1

function gradeModule() {

    case $module in
        MyPoint|Mypoint|mypoint)
            echo '<!-- UML-INJECT -->' >> "${RESULT}"
            ;;

        W9dot1|w9dot1|W09dot1)
            echo "### Case 1 (3,4)" >> "${RESULT}"
            echo "#### Expected" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Using method 1, the distance between (0,0) and (3,4) is 5.00" >> "${RESULT}"
            echo "Using method 2, the distance between (0,0) and (3,4) is 5.00" >> "${RESULT}"
            echo "Using method 3, the distance between (0,0) and (3,4) is 5.00" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "3\n4\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"

            echo "### Case 2 (10,10)" >> "${RESULT}"
            echo "#### Expected" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Using method 1, the distance between (0,0) and (10,10) is 14.14" >> "${RESULT}"
            echo "Using method 2, the distance between (0,0) and (10,10) is 14.14" >> "${RESULT}"
            echo "Using method 3, the distance between (0,0) and (10,10) is 14.14" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "10\n10\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"

            echo "### Case 3 (-100,-23)" >> "${RESULT}"
            echo "#### Expected" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Using method 1, the distance between (0,0) and (-100,-23) is 102.61" >> "${RESULT}"
            echo "Using method 2, the distance between (0,0) and (-100,-23) is 102.61" >> "${RESULT}"
            echo "Using method 3, the distance between (0,0) and (-100,-23) is 102.61" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "%d\n%d\n" -100 -23 | java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"

            echo "### Case 4 (0,0)" >> "${RESULT}"
            echo "#### Expected" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Using method 1, the distance between (0,0) and (0,0) is 0.00" >> "${RESULT}"
            echo "Using method 2, the distance between (0,0) and (0,0) is 0.00" >> "${RESULT}"
            echo "Using method 3, the distance between (0,0) and (0,0) is 0.00" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "0\n0\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;

    esac
}

source $(dirname $0)/autograder_driver.sh