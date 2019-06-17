#!/usr/bin/env bash

export JAVA_MODULES=(A7dot8 A7dot11)

function gradeModule() {

    # From the book
    echo "CASE 1: Example from the book: 1.9 2.5 3.7 2 1 6 3 4 5 2" >> "${RESULT}"
    echo "-> mean(3.11) stdev(1.55738)" >> "${RESULT}"
    printf "\n" >> "${RESULT}"
    printf "1.9 2.5 3.7 2 1 6 3 4 5 2" | java ${javaClass} >> "${RESULT}" 2>&1

    printf "\n\n" >> "${RESULT}"

    # Our own sequence
    echo "CASE 2: Random numbers: 66.9 6.4 22.21 20.9 85.71 51.54 96.1 76.48 9.69 10.1" >> "${RESULT}"
    echo "-> mean(44.6) stdev(34.69753)" >> "${RESULT}"
    printf "\n" >> "${RESULT}"
    printf "66.9 6.4 22.21 20.9 85.71 51.54 96.1 76.48 9.69 10.1" | java ${javaClass} >> "${RESULT}" 2>&1
    
    printf "\n\n" >> "${RESULT}"

    # Non-double input
    echo "CASE 3: Should handle the bad input gracefully: 1 2 3 four 5 6 7 8 9 10" >> "${RESULT}"
    printf "\n" >> "${RESULT}"
    printf "1 2 3 four 5 6 7 8 9 10" | java ${javaClass} >> "${RESULT}" 2>&1

    printf "\n\n\n\n" >> "${RESULT}"
    
}

source $(dirname $0)/autograder_driver.sh