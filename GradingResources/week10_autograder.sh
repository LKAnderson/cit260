#!/usr/bin/env bash

export RESULT_TITLE="WEEK 10 PROGRAMMING EXERCISE"
export JAVA_MODULES=(W10dot1 w10dot1 Triangle GeometricObject)
export HAS_UML_DIAGRAM=1
export HAS_FINISHED_HOOK=1

function onFinished() {
    UMLS=$(find . -type f \( -name \*.puml -o -name \*.plantuml -o -name \*.pu \))
    if [ ${#UMLS[@]} -ne 0 ]; then
        echo "## UML Files" >> "${RESULT}"
        echo '<!-- UML-INJECT -->' >> "${RESULT}"
    fi
}

function gradeModule() {

    case $module in

        W10dot1|w10dot1)
            echo "#### Case 1" >> "${RESULT}"
            echo "##### Inputs" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Triangle 1: blue   true  3 4 5" >> "${RESULT}"
            echo "Triangle 2: red    false 6 7 8" >> "${RESULT}"
            echo "Triangle 3: yellow true  9 10 11" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "##### Expected" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Side1: 3.00, Side2: 4.00, Side3: 5.00" >> "${RESULT}"
            echo "Created on Sat Nov 23 18:54:30 CST 2019" >> "${RESULT}"
            echo "color: blue and filled: true" >> "${RESULT}"
            echo "The area is: 6.00" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Side1: 6.00, Side2: 7.00, Side3: 8.00" >> "${RESULT}"
            echo "Created on Sat Nov 23 18:54:49 CST 2019" >> "${RESULT}"
            echo "color: red and filled: false" >> "${RESULT}"
            echo "The area is: 20.33" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Side1: 9.00, Side2: 10.00, Side3: 11.00" >> "${RESULT}"
            echo "Created on Sat Nov 23 18:55:10 CST 2019" >> "${RESULT}"
            echo "color: yellow and filled: true" >> "${RESULT}"
            echo "The area is: 42.43" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "##### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "blue\ntrue\n3 4 5\nred\nfalse\n6 7 8\nyellow\ntrue\n9 10 11\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"

            echo "#### Case 2" >> "${RESULT}"
            echo "##### Inputs" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "<empty color> true 3 4 5" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "##### Expected" >> "${RESULT}"
            echo "An error should be reported" >> "${RESULT}"
            echo "##### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "\ntrue\n3 4 5\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"

            echo "#### Case 3" >> "${RESULT}"
            echo "##### Inputs" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "blue true -3 4 5" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "##### Expected" >> "${RESULT}"
            echo "An error should be reported" >> "${RESULT}"
            echo "##### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "blue\ntrue\n%d 4 5\n" -3 | java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;

    esac
}

source $(dirname $0)/autograder_driver.sh