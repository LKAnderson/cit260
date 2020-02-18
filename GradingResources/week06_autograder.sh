#!/usr/bin/env bash

export RESULT_TITLE="WEEK 6 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W6dot1 w6dot1 W06dot1 w06dot1 W6dot01 W6dot2 w6dot2 W06dot2 w06dot2)

function gradeModule() {
    # Run the class
    case $module in 
        *6[Dd]ot*1)
            output "<h4>Case 1: \$1000 @9%</h4><h5>Expected Output</h5>"
            output '<pre>'
            output "Years   Future Value"
            output "1       \$1093.81"
            output "2       \$1196.41"
            output "3       \$1308.65"
            output "4       \$1431.41"
            output "5       \$1565.68"
            output "6       \$1712.55"
            output "7       \$1873.20"
            output "8       \$2048.92"
            output "9       \$2241.12"
            output "10      \$2451.36"
            output '</pre>'
            output "<h5>Your Output</h5>"
            output '<pre>'
            output "$(printf "1000\n9\n" | java -Djava.security.manager $javaClass 2>&1)" 
            output '</pre>' 
            
            output "<h4>Case 2: Invalid Investment (-\$1000)</h4><h5>Your Output</h5>"
            output '<pre>'
            output "$(printf "%d\n9\n" -1000 | java -Djava.security.manager $javaClass 2>&1)"
            output '</pre>'
            
            output "<h4>Case 3: Invalid Percent (100)</h4><h5>Your Output</h5>"
            output '<pre>' 
            output "$(printf "1000\n100\n" | java -Djava.security.manager $javaClass 2>&1)" 
            output "</pre>"
            ;;

        *6[Dd]ot*2)
            output "<h4>Expected Output</h4>"
            output '<pre>'
            output "Celsius        Fahrenheit     |    Fahrenheit     Celsius"
            output "----------------------------------------------------------"
            output "40.0           104.0          |    120.0          48.89"
            output "39.0           102.2          |    110.0          43.33"
            output "38.0           100.4          |    100.0          37.78"
            output "37.0           98.6           |    90.0           32.22"
            output "36.0           96.8           |    80.0           26.67"
            output "35.0           95.0           |    70.0           21.11"
            output "34.0           93.2           |    60.0           15.56"
            output "33.0           91.4           |    50.0           10.00"
            output "32.0           89.6           |    40.0           4.44"
            output "31.0           87.8           |    30.0           -1.11"
            output '</pre>'
            output "<h4>Your Output</h4>"
            output '<pre>'
            output "$(java -Djava.security.manager $javaClass 2>&1)"
            output '</pre>'
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh