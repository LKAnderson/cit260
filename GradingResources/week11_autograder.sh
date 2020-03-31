#!/usr/bin/env bash

export RESULT_TITLE="WEEK 11 PROGRAMMING EXERCISE"
export JAVA_MODULES=(W11dot1 w11dot1 A11dot1 a11dot1)

function gradeModule() {

    case $module in

        *11*ot*)
            output "<h4>Test Case</h4>"
            output "<h5>Inputs</h5>"
            output "<pre>"
            output "10 20 13 fourty 40 50 sixty 6x 60 70 80 19 100 (separated by newlines)"
            output "</pre>"
            output "<h5Expected</h5>"
            output "<pre>"
            output "Please enter 10 integers..."
            output "Enter integer #1: 10"
            output "Enter integer #2: 20"
            output "Enter integer #3: 13"
            output "Enter integer #4: fourty"
            output "Please enter a valid integer."
            output "Enter integer #4: 40"
            output "Enter integer #5: 50"
            output "Enter integer #6: sixty"
            output "Please enter a valid integer."
            output "Enter integer #6: 6x"
            output "Please enter a valid integer."
            output "Enter integer #6: 60"
            output "Enter integer #7: 70"
            output "Enter integer #8: 80"
            output "Enter integer #9: 19"
            output "Enter integer #10: 100"
            output "The average value is: 46.20"
            output "</pre>"
            output "<h5>Your Output</h5>"
            output "<pre>"
            output "$(printf "10\n20\n13\nfourty\n40\n50\nsixty\n6x\n60\n70\n80\n19\n100\n" | java -Djava.security.manager -Djava.security.policy="${SCRIPTDIR}/week11_policy" $module 2>&1)"
            output '</pre>'
            output "<h5>data.txt</h5>"
            output "<pre>"
            if [ -f data.txt ]; then
                output "$(cat data.txt)"
            else
                output "File not found"
            fi
            output "</pre>"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh
