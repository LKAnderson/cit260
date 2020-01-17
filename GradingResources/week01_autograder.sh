#!/usr/bin/env bash

export RESULT_TITLE="WEEK 1 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W1dot1 W1dot2 A1dot1 A1dot2 Main w1dot1 w1dot2 a1dot1 a1dot2)

function gradeModule() {
    case $module in 
        W1dot1|w1dot1|A1dot1|a1dot1)
            echo "<h4>Expected Output</h4>" >> "${RESULT}"
            echo '<pre>' >> "${RESULT}"
            echo "Student Name" >> "${RESULT}"
            echo "CIT 260 Section 4" >> "${RESULT}"
            echo "Student Hometown" >> "${RESULT}"
            echo "Favorite Dessert" >> "${RESULT}"
            echo '</pre>' >> "${RESULT}"
            echo "<h4>Your Output</h4>" >> "${RESULT}"
            echo '<pre>' >> "${RESULT}"
            java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '</pre>' >> "${RESULT}"
            ;;

        W1dot2|w1dot2|A1dot2|a1dot2)
            echo "<h4>Expected Output</h4>" >> "${RESULT}"
            echo '<pre>' >> "${RESULT}"
            echo "    J    A  V     V  A" >> "${RESULT}"
            echo "    J   A A  V   V  A A" >> "${RESULT}"
            echo "J   J  AAAAA  V V  AAAAA" >> "${RESULT}"
            echo " J J  A     A  V  A     A" >> "${RESULT}"
            echo '</pre>' >> "${RESULT}"
            echo "<h4>Your Output</h4>" >> "${RESULT}"
            echo '<pre>' >> "${RESULT}"
            java -Djava.security.manager $module >> "${RESULT}" 2>&1
            echo '</pre>' >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh