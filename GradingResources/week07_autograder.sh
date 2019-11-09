#!/usr/bin/env bash

export RESULT_TITLE="WEEK 7 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W7dot1 w7dot1 W07dot1 W7dot2 w7dot2 W07dot2)

function gradeModule() {

    case $module in
        W7dot1|w7dot1|W07dot1)
            echo "### CASE 1: Example from the assignment" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Program description..." >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Inputs: 5.3 6.2 12.1 8.6 7.8" >> "${RESULT}"
            echo "The mean should be 8.00" >> "${RESULT}"
            printf '\n```\n' >> "${RESULT}"
            echo "### Results" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "5.3\n6.2\n12.1\n8.6\n7.8\n" | java -Djava.security.manager ${javaClass} >> "${RESULT}" 2>&1
            printf '\n```\n' >> "${RESULT}"

            # Our own sequence
            echo "### CASE 2" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Program description..." >> "${RESULT}"
            echo "Inputs: 66.9 6.4 22.21 209.9 85.71" >> "${RESULT}"
            echo "The mean should be 40.42" >> "${RESULT}"
            printf '\n```\n' >> "${RESULT}"
            echo "### Results" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "66.9\n6.4\n22.21\n20.9\n85.71\n" | java -Djava.security.manager ${javaClass} >> "${RESULT}" 2>&1
            printf '\n```\n' >> "${RESULT}"
            ;;

        W7dot2|w7dot2|W07dot2)
            echo "### CASE 1: Example from the assignment" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Program description..." >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Inputs: 3.5 4 6.1 6 7.5" >> "${RESULT}"
            echo "The mean should be 5.42" >> "${RESULT}"
            echo "The standard deviation should be 1.65 (1.47 is also acceptable)" >> "${RESULT}"
            printf '\n```\n' >> "${RESULT}"
            echo "### Results" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "3.5\n4\n6.1\n6\n7.5\n" | java -Djava.security.manager  ${javaClass} >> "${RESULT}" 2>&1
            printf '\n```\n' >> "${RESULT}"

            # Our own sequence
            echo "### CASE 2" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Program description..." >> "${RESULT}"
            echo "Inputs: 66.9 6.4 22.21 209.9 85.71" >> "${RESULT}"
            echo "The mean should be 40.42" >> "${RESULT}"
            echo "The standard deviation should be 33.99 (30.41 is also acceptable)" >> "${RESULT}"
            printf '\n```\n' >> "${RESULT}"
            echo "### Results" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "66.9\n6.4\n22.21\n20.9\n85.71\n" | java -Djava.security.manager ${javaClass} >> "${RESULT}" 2>&1
            printf '\n```\n' >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh