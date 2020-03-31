#!/usr/bin/env bash

export RESULT_TITLE="WEEK 8 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W8dot1 w8dot1 W08dot1 A8dot1 Rectangle W8dot2 w8dot2 W08dot2 A8dot2)
export HAS_UML_DIAGRAM=1

function gradeModule() {

    case $module in
        *ectangle)
            output "This file does not need to be run directly."
            output '<!-- UML-INJECT -->'
            ;;

        *8dot*1)
            output "<h4>Expected Output</h4>"
            output '<pre>'
            output "Rectangle 1:"
            output "height = 4.00"
            output "width = 40.00"
            output "area = 160.00"
            output "permiter = 88.00"
            output ""
            output "Rectangle 2:"
            output "height = 3.50"
            output "width = 5.00"
            output "area = 17.50"
            output "permiter = 17.00"
            output '</pre>'
            output "</h4>Your Output</h4>"
            output '<pre>'
            output "$(echo "" | java -Djava.security.manager $module 2>&1)" 
            output '</pre>'
            ;;

        *8dot*2)
            output "<h4>Expected Output</h4>"
            output '<pre>'
            output "Wed Dec 31 17:00:10 MST 1969"
            output "Wed Dec 31 17:01:40 MST 1969"
            output "Wed Dec 31 19:46:40 MST 1969"
            output "Thu Jan 01 20:46:40 MST 1970"
            output "Mon Jan 12 06:46:40 MST 1970"
            output "Sun Apr 26 10:46:40 MST 1970"
            output "Sat Mar 03 02:46:40 MST 1973"
            output '</pre>'
            output "</h4>Your Output</h4>"
            output '<pre>'
            output "$(echo "" | java -Djava.security.manager $module 2>&1)"
            output '</pre>'
            ;;

    esac
}

source $(dirname $0)/autograder_driver.sh