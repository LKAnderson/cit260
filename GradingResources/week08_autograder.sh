#!/usr/bin/env bash

export RESULT_TITLE="WEEK 8 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W8dot1 w8dot1 W08dot1 Rectangle W8dot2 w8dot2 W08dot2)
export HAS_UML_DIAGRAM=1

function gradeModule() {

    case $module in
        Rectangle|rectangle)
            echo '<!-- UML-INJECT -->' >> "${RESULT}"
            ;;

        W8dot1|w8dot1|W08dot1)
            echo "### Expected Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "rectangle1: width: 40.00, height: 4.00, area; 160.00, permiter: 88.00" >> "${RESULT}"
            echo "rectangle2: width: 5.00, height: 3.50, area; 17.50, permiter: 17.00" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;

        W8dot2|w8dot2|W08dot2)
            echo "### Expected Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Wed Dec 31 17:00:10 MST 1969" >> "${RESULT}"
            echo "Wed Dec 31 17:01:40 MST 1969" >> "${RESULT}"
            echo "Wed Dec 31 19:46:40 MST 1969" >> "${RESULT}"
            echo "Thu Jan 01 20:46:40 MST 1970" >> "${RESULT}"
            echo "Mon Jan 12 06:46:40 MST 1970" >> "${RESULT}"
            echo "Sun Apr 26 10:46:40 MST 1970" >> "${RESULT}"
            echo "Sat Mar 03 02:46:40 MST 1973" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;

    esac
}

source $(dirname $0)/autograder_driver.sh