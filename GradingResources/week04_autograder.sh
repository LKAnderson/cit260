#!/usr/bin/env bash

export RESULT_TITLE="WEEK 4 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W4dot1 w4dot1 Wk4dot1 a4dot1 A4dot1 W4dot2 w4dot2 Wk4dot2 a4dot2 A4dot2)


gradeModule() {

    # Run the class
    case $module in 
        W4dot1|w4dot1|Wk4dot1|A4dot1|a4dot1)
            output "<h4>Your Results</h4>"
            output "<pre>"
            output "# 0 = 0000"
            output "$(echo "0" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 1 = 0001"
            output "$(echo "1" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 2 = 0010"
            output "$(echo "2" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 3 = 0011"
            output "$(echo "3" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 4 = 0100"
            output "$(echo "4" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 5 = 0101"
            output "$(echo "5" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 6 = 0110"
            output "$(echo "6" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 7 = 0111"
            output "$(echo "7" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 8 = 1000"
            output "$(echo "8" | java -Djava.security.manager $javaClass 2>&1)"
            output "# 9 = 1001"
            output "$(echo "9" | java -Djava.security.manager $javaClass 2>&1)"
            output "# A = 1010"
            output "$(echo "A" | java -Djava.security.manager $javaClass 2>&1)"
            output "# B = 1011"
            output "$(echo "B" | java -Djava.security.manager $javaClass 2>&1)"
            output "# C = 1100"
            output "$(echo "C" | java -Djava.security.manager $javaClass 2>&1)"
            output "# d = 1101"
            output "$(echo "d" | java -Djava.security.manager $javaClass 2>&1)"
            output "# E = 1110"
            output "$(echo "E" | java -Djava.security.manager $javaClass 2>&1)"
            output "# F = 1111"
            output "$(echo "F" | java -Djava.security.manager $javaClass 2>&1)"
            output "# T = Invalid"
            output "$(echo "T" | java -Djava.security.manager $javaClass 2>&1)"
            output "# : = Invalid"
            output "$(echo ":" | java -Djava.security.manager $javaClass 2>&1)"
            output "# &lt;blank&gt; = Invalid"
            output "$(echo "" | java -Djava.security.manager $javaClass 2>&1)"
            output "</pre>"
            ;;

        W4dot2|w4dot2|Wk4dot2|A4dot2|a4dot2)
            output "<h4>Expected Results</h4>"
            output "<pre>"
            output "Pay Stub for Jane Doe" 
            output "Hours Worked:               40" 
            output "Hourly Wage:            \$25.00" 
            output "Gross Pay:            \$1000.00" 
            output "State Tax Withheld:     \$90.00" 
            output "Federal Tax Withheld:  \$200.00" 
            output "Net Pay:               \$710.00" 
            output "</pre>"
            output "<h4>Your Results</h4>"
            output "<pre>"
            output "$(printf "Jane Doe\n40\n25\n" | java -Djava.security.manager $javaClass 2>&1)"
            output "</pre>"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh
