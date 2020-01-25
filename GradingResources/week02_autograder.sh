#!/usr/bin/env bash

export RESULT_TITLE="WEEK 1 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W2dot1 w2dot1 W2Dot1 A2dot1 a2dot1 W2dot2 w2dot2 W2Dot2 A2dot2 a2dot2)


function gradeModule() {
    
    case $module in 
        W2dot1|w2dot1|W2Dot1|A2dot1|a2dot1)
            output "<h4>Expected Calculations</h4>"
            output '<pre>'
            output "Input: 43.5:      43.50C = 110.30F"
            output "Input: 45.0:      45.00C = 113.00F"
            output "Input: 100:      100.00C = 212.00F"
            output "Input: 100.0123: 100.01C = 212.02F"
            output "Input: 23.0:      23.00C =  73.40F"
            output '</pre>'
            output "<h4>Your Output</h4>"
            formattingDisclaimer
            output '<pre>'
            output $(printf "43.5\n" | java -Djava.security.manager $module 2>&1)
            output ""
            output ""
            output $(printf "45.0\n" | java -Djava.security.manager $module 2>&1)
            output ""
            output ""
            output $(printf "100\n" | java -Djava.security.manager $module  2>&1)
            output ""
            output ""
            output $(printf "100.0123\n" | java -Djava.security.manager $module 2>&1)
            output ""
            output ""
            output $(printf "23.0\n" | java -Djava.security.manager $module  2>&1)
            output '</pre>'
            ;;

        W2dot2|w2dot2|W2Dot2|A2dot2|a2dot2)
            echo "<h4>Expected Calculations</h4>" >> "${RESULT}"
            echo '<pre>' >> "${RESULT}"
            printf "Input: 12.50 and 15:\n Tip: \$1.88\n Tax: \$0.40\n Total: \$14.78\n\n" >> "${RESULT}"
            printf "Input: 20 and 18:\n Tip: \$3.60\n Tax: \$0.64\n Total: \$24.24" >> "${RESULT}"
            echo '</pre>' >> "${RESULT}"
            echo "<h4>Your Output</h4>" >> "${RESULT}"
            formattingDisclaimer
            echo '<pre>' >> "${RESULT}"
            printf "12.50\n15\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1
            printf "\n\n" >> "${RESULT}"
            printf "20\n18\n" | java -Djava.security.manager $module >> "${RESULT}" 2>&1
            echo '</pre>' >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh