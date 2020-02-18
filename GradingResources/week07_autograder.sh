#!/usr/bin/env bash

export RESULT_TITLE="WEEK 7 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W7dot1 w7dot1 W07dot1 W7dot2 w7dot2 W07dot2)

function gradeModule() {

    case $module in
        W7dot1|w7dot1|W07dot1)
            output "<h4>CASE 1: Example from the assignment</h4>"
            output '<pre>'
            output "Inputs: 5.3 6.2 12.1 8.6 7.8"
            output "The mean should be 8.00"
            output '</pre>'
            output "<h5>Results</h5>"
            output '<pre>'
            output "$(printf "5.3\n6.2\n12.1\n8.6\n7.8\n" | java -Djava.security.manager ${javaClass} 5.3 6.2 12.1 8.6 7.8 2>&1)"
            output '</pre>'

            # Our own sequence
            output "<h4>CASE 2</h4>"
            output '<pre>'
            output "Inputs: 66.9 6.4 22.21 20.9 85.71"
            output "The mean should be 40.42"
            output '</pre>'
            output "<h5>Results</h5>"
            output '<pre>'
            output "$(printf "66.9\n6.4\n22.21\n20.9\n85.71\n" | java -Djava.security.manager ${javaClass} 66.9 6.4 22.21 20.9 85.71 2>&1)"
            output '</pre>'
            ;;

        W7dot2|w7dot2|W07dot2)
            output "<h4>CASE 1: Example from the assignment</h4>"
            output '<pre>'
            output "Inputs: 3.5 4 6.1 6 7.5"
            output "The mean should be 5.42"
            output "The standard deviation should be 1.65"
            output '</pre>'
            output "<h5>Results</h5>"
            output '<pre>'
            output "$(printf "3.5\n4\n6.1\n6\n7.5\n" | java -Djava.security.manager  ${javaClass} 3.5 4 6.1 6 7.5 2>&1)"
            output '</pre>'

            # Our own sequence
            output "<h4>CASE 2</h4>"
            output '<pre>'
            output "Inputs: 66.9 6.4 22.21 20.9 85.71"
            output "The mean should be 40.42"
            output "The standard deviation should be 33.99 (30.41 is also acceptable)"
            output '</pre>'
            output "<h5>Results</h5>"
            output '<pre>'
            output "$(printf "66.9\n6.4\n22.21\n20.9\n85.71\n" | java -Djava.security.manager ${javaClass} 66.9 6.4 22.21 20.9 85.71 2>&1)"
            output '</pre>'
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh