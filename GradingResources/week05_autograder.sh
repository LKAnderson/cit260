#!/usr/bin/env bash

export RESULT_TITLE="WEEK 5 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W5dot1 w5dot1 A5dot1 W5dot2 w5dot2 A5dot2)

gradeModule() {
    case $module in 
        W5dot1|w5dot1|A5dot1)
            output "<h4>Expected Output</h4>"
            output "<pre>"
            output ""
            output "kilograms     pounds"
            output "---------     ------"
            output "1             2.2   "
            output "3             6.6   "
            output "5             11.0  "
            output "7             15.4  "
            output "9             19.8  "
            output "11            24.2  "
            output "13            28.6  "
            output "15            33.0  "
            output "</pre>"
            output "<h4>Your Output</h4>"
            output "<pre>"
            output "$(java -Djava.security.manager $module 2>&1)"
            output "</pre>" 
            ;;

        W5dot2|w5dot2|A5dot2)
            output "<h4>Expected Output</h4>"
            output "<pre>"
            output "120 150 180 210 240 270 300 330 360 390"
            output "420 450 480 510 540 570 600 630 660 690"
            output "720 750 780 810 840 870 900 930 960 990"
            output '</pre>'
            output "<h4>Your Output</h4>"
            output "<pre>"
            output "$(java -Djava.security.manager $module 2>&1)"
            output "</pre>"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh


# FYI, the 4’s here don’t match the actual length of the strings you’re going to put there. It can be tricky when dealing with numbers because if you don’t plan for enough width, your formatting will be thrown off since the “4” means “at least 4 characters, but more if needed.”