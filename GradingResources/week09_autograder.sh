#!/usr/bin/env bash

export RESULT_TITLE="WEEK 9 PROGRAMMING EXERCISE"
export JAVA_MODULES=(W9dot1 w9dot1 W09dot1 A9dot1 a9dot1 MyPoint Mypoint mypoint)
export HAS_UML_DIAGRAM=1

function gradeModule() {

    case $module in
        *y*oint)
            output '<!-- UML-INJECT -->'
            ;;

        *9*ot1)
            output "<h4>Case 1 (3,4)</h4>"
            output "<h5>Expected</h5>"
            output "<pre>"
            output "Using method 1, the distance between (0,0) and (3,4) is 5.00"
            output "Using method 2, the distance between (0,0) and (3,4) is 5.00"
            output "Using method 3, the distance between (0,0) and (3,4) is 5.00"
            output "</pre>"
            output "<h5>Your Output</h5>"
            output "<pre>"
            output "$(printf "3\n4\n" | java -Djava.security.manager $module 3 4 2>&1)"
            output "</pre>"

            output "<h4>Case 2 (10,10)</h4>"
            output "<h5>Expected</h5>"
            output "<pre>"
            output "Using method 1, the distance between (0,0) and (10,10) is 14.14"
            output "Using method 2, the distance between (0,0) and (10,10) is 14.14"
            output "Using method 3, the distance between (0,0) and (10,10) is 14.14"
            output "</pre>"
            output "<h5>Your Output</h5>"
            output "<pre>"
            output "$(printf "10\n10\n" | java -Djava.security.manager $module 10 10 2>&1)"
            output "</pre>"

            output "<h4>Case 3 (-100,-23)</h4>"
            output "<h5>Expected</h5>"
            output "<pre>"
            output "Using method 1, the distance between (0,0) and (-100,-23) is 102.61"
            output "Using method 2, the distance between (0,0) and (-100,-23) is 102.61"
            output "Using method 3, the distance between (0,0) and (-100,-23) is 102.61"
            output "</pre>"
            output "<h5>Your Output</h5>"
            output "<pre>"
            output "$(printf "%d\n%d\n" -100 -23 | java -Djava.security.manager $module -100 -23 2>&1)"
            output "</pre>"

            output "<h4>Case 4 (0,0)</h4>"
            output "<h5>Expected</h5>"
            output "<pre>"
            output "Using method 1, the distance between (0,0) and (0,0) is 0.00"
            output "Using method 2, the distance between (0,0) and (0,0) is 0.00"
            output "Using method 3, the distance between (0,0) and (0,0) is 0.00"
            output "</pre>"
            output "<h5>Your Output</h5>"
            output "<pre>"
            output "$(printf "0\n0\n" | java -Djava.security.manager $module 0 0 2>&1)"
            output "</pre>"
            ;;

    esac
}

source $(dirname $0)/autograder_driver.sh