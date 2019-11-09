#!/usr/bin/env bash

export RESULT_TITLE="WEEK 4 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W4dot1 w4dot1 Wk4dot1 W4dot2 w4dot2 Wk4dot2)


gradeModule() {

    # Run the class
    case $module in 
        W4dot1|w4dot1|Wk4dot1)
            echo "### Case: 0 should be 0000" >> "${RESULT}"
            echo "0" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 1 should be 0001" >> "${RESULT}"
            echo "1" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 2 should be 0010" >> "${RESULT}"
            echo "2" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 3 should be 0011" >> "${RESULT}"
            echo "3" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 4 should be 0100" >> "${RESULT}"
            echo "4" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 5 should be 0101" >> "${RESULT}"
            echo "5" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 6 should be 0110" >> "${RESULT}"
            echo "6" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 7 should be 0111" >> "${RESULT}"
            echo "7" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 8 should be 1000" >> "${RESULT}"
            echo "8" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: 9 should be 1001" >> "${RESULT}"
            echo "9" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: A should be 1010" >> "${RESULT}"
            echo "A" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: b should be 1011" >> "${RESULT}"
            echo "b" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: C should be 1100" >> "${RESULT}"
            echo "C" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: D should be 1101" >> "${RESULT}"
            echo "D" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: E should be 1110" >> "${RESULT}"
            echo "E" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: F should be 1111" >> "${RESULT}"
            echo "F" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: T should be invalid" >> ${RESULT} 
            echo "T" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: ':' should be invalid (defined between digits and letters in ASCII)" >> ${RESULT} 
            echo ":" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            echo "### Case: <blank> should be invalid" >> "${RESULT}"; 
            echo "" | java -Djava.security.manager $javaClass > "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            ;;

        W4dot2|w4dot2|Wk4dot2)
            echo "### Case 1" >> "${RESULT}"
            echo "Employee:    Jane Doe" >> "${RESULT}"
            echo "Hours worked:      40" >> "${RESULT}"
            echo "Hourly rate:   \$25.00" >> "${RESULT}"
            echo "Gross pay:   \$1000.00" >> "${RESULT}"
            echo "Federal tax:  \$200.00" >> "${RESULT}"
            echo "State tax:     \$90.00" >> "${RESULT}"
            echo "Net pay:      \$710.00" >> "${RESULT}"
            echo "" >> "${RESULT}"
            printf "Jane Doe\n40\n25\n" | java -Djava.security.manager $javaClass >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            
            printf "### Case 2: Now with invalid inputs...\n\n" >> "${RESULT}"
            echo "Employee:  <blank>" >> "${RESULT}"
            echo "Hours worked:   -1" >> "${RESULT}"
            echo "Hourly rate:    -1" >> "${RESULT}"
            echo "" >> "${RESULT}"
            printf "   \n%d\n%d" -1 -1 | java -Djava.security.manager $javaClass >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"

            printf "### Case 3: Now with invalid numeric inputs...\n\n" >> "${RESULT}"
            echo "Employee: John Doe" >> "${RESULT}"
            echo "Hours worked:   -1" >> "${RESULT}"
            echo "Hourly rate:    -1" >> "${RESULT}"
            echo "" >> "${RESULT}"
            printf "John Doe\n%d\n%d" -1 -1 | java -Djava.security.manager $javaClass >> "$$" 2>&1
            indent 4 "$$" >> "${RESULT}"; rm "$$"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh