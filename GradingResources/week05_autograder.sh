#!/usr/bin/env bash

export RESULT_TITLE="WEEK 5 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W5dot1 w5dot1 W5dot2 w5dot2)

gradeModule() {
    case $module in 
        W5dot1|w5dot1)
            echo "### Expected Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "kilograms     pounds" >> "${RESULT}"
            echo "---------     ------" >> "${RESULT}"
            echo "1             2.2   " >> "${RESULT}"
            echo "3             6.6   " >> "${RESULT}"
            echo "5             11.0  " >> "${RESULT}"
            echo "7             15.4  " >> "${RESULT}"
            echo "9             19.8  " >> "${RESULT}"
            echo "11            24.2  " >> "${RESULT}"
            echo "13            28.6  " >> "${RESULT}"
            echo "15            33.0  " >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            java $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;

        W5dot2|w5dot2)
            echo "### Expected Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "120 150 180 210 240 270 300 330 360 390" >> "${RESULT}"
            echo "420 450 480 510 540 570 600 630 660 690" >> "${RESULT}"
            echo "720 750 780 810 840 870 900 930 960 990" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            java $module >> "${RESULT}" 2>&1
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh


# FYI, the 4’s here don’t match the actual length of the strings you’re going to put there. It can be tricky when dealing with numbers because if you don’t plan for enough width, your formatting will be thrown off since the “4” means “at least 4 characters, but more if needed.”