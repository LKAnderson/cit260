#!/usr/bin/env bash

export RESULT_TITLE="WEEK 1 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W2dot1 w2dot1 W2Dot1 A2dot1 a2dot1 W2dot2 w2dot2 W2Dot2 A2dot2 a2dot2)

function gradeModule() {
    
    case $module in 
        W2dot1|w2dot1|W2Dot1|A2dot1|a2dot1)
            echo "#### Expected Calculations" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Input: 43.5:      43.50C = 110.30F" >> "${RESULT}"
            echo "Input: 45.0:      45.00C = 113.00F" >> "${RESULT}"
            echo "Input: 100:      100.00C = 212.00F" >> "${RESULT}"
            echo "Input: 100.0123: 100.01C = 212.02F" >> "${RESULT}"
            echo "Input: 23.0:      23.00C =  73.40F" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### Your Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "43.5\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            printf "45.0\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            printf "100\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1 
            printf "\n\n" >> "${RESULT}"
            printf "100.0123\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1
            printf "\n\n" >> ${RESULT}
            printf "23.0\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;

        W2dot2|w2dot2|W2Dot2|A2dot2|a2dot2)
         echo "#### Expected Calculations" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "Input: 12.50 and 15:\n Tip: \$1.88\n Tax: \$0.40\n Total: \$14.78\n\n" >> "${RESULT}"
            printf "Input: 20 and 18:\n Tip: \$3.60\n Tax: \$0.64\n Total: \$24.24" >> "${RESULT}"
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### Your Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "12.50\n15\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            printf "20\n18\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh