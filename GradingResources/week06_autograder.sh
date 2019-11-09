#!/usr/bin/env bash

export RESULT_TITLE="WEEK 6 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W6dot1 w6dot1 W06dot1 w06dot1 W6dot2 w6dot2 W06dot2 w06dot2)

function gradeModule() {
    # Run the class
    case $module in 
        W6dot1|w6dot1|W06dot1|w06dot1)
            echo "### Case 1: \$1000 @9% Expected Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Program description..." >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Years   Future Value" >> "${RESULT}"
            echo "1       \$1093.81" >> "${RESULT}"
            echo "2       \$1196.41" >> "${RESULT}"
            echo "3       \$1308.65" >> "${RESULT}"
            echo "4       \$1431.41" >> "${RESULT}"
            echo "5       \$1565.68" >> "${RESULT}"
            echo "6       \$1712.55" >> "${RESULT}"
            echo "7       \$1873.20" >> "${RESULT}"
            echo "8       \$2048.92" >> "${RESULT}"
            echo "9       \$2241.12" >> "${RESULT}"
            echo "10      \$2451.36" >> "${RESULT}"
            printf '\n```\n' >> "${RESULT}"
            echo "### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "1000\n9\n" | java -Djava.security.manager $javaClass >> "${RESULT}" 2>&1; 
            printf '\n```\n' >> "${RESULT}"
            
            echo "### Case 2: Invalid Investment (-\$1000)" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "%d\n9\n" -1000 | java -Djava.security.manager $javaClass >> "${RESULT}" 2>&1; 
            printf '\n```\n' >> "${RESULT}"
            
            echo "### Case 3: Invalid Percent (100)" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "1000\n100\n" | java -Djava.security.manager $javaClass >> "${RESULT}" 2>&1; 
            printf '\n```\n' >> "${RESULT}"
            ;;

        W6dot2|w6dot2|W06dot2|w06dot2)
            echo "### Expected Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Program description..." >> "${RESULT}"
            echo "Celsius        Fahrenheit     |    Fahrenheit     Celsius" >> "${RESULT}"
            echo "----------------------------------------------------------" >> "${RESULT}"
            echo "40.0           104.0          |    120.0          48.89" >> "${RESULT}"
            echo "39.0           102.2          |    110.0          43.33" >> "${RESULT}"
            echo "38.0           100.4          |    100.0          37.78" >> "${RESULT}"
            echo "37.0           98.6           |    90.0           32.22" >> "${RESULT}"
            echo "36.0           96.8           |    80.0           26.67" >> "${RESULT}"
            echo "35.0           95.0           |    70.0           21.11" >> "${RESULT}"
            echo "34.0           93.2           |    60.0           15.56" >> "${RESULT}"
            echo "33.0           91.4           |    50.0           10.00" >> "${RESULT}"
            echo "32.0           89.6           |    40.0           4.44" >> "${RESULT}"
            echo "31.0           87.8           |    30.0           -1.11" >> "${RESULT}"
            printf '\n```\n' >> "${RESULT}"
            echo "### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            java -Djava.security.manager $javaClass >> "${RESULT}" 2>&1; 
            printf '\n```\n' >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh