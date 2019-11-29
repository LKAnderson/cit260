#!/usr/bin/env bash

export RESULT_TITLE="WEEK 11 PROGRAMMING EXERCISE"
export HAS_USERDIR_HOOK=1

function onUserDir() {
    export JAVA_MODULES=$(for f in $(ls -R | grep .java | grep -v pdf | sort -u); do echo "${f%.*}"; done)
}

function gradeModule() {

    case $module in

        W11dot1|w11dot1)
            echo "### Test Case" >> "${RESULT}"
            echo "#### Inputs" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "10 20 13 fourty 40 50 sixty 6x 60 70 80 19 100 (separated by newlines)" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### Expected" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "Program description..." >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Please enter 10 integers..." >> "${RESULT}"
            echo "Enter integer #1: 10" >> "${RESULT}"
            echo "Enter integer #2: 20" >> "${RESULT}"
            echo "Enter integer #3: 13" >> "${RESULT}"
            echo "Enter integer #4: fourty" >> "${RESULT}"
            echo "Please enter a valid integer." >> "${RESULT}"
            echo "Enter integer #4: 40" >> "${RESULT}"
            echo "Enter integer #5: 50" >> "${RESULT}"
            echo "Enter integer #6: sixty" >> "${RESULT}"
            echo "Please enter a valid integer." >> "${RESULT}"
            echo "Enter integer #6: 6x" >> "${RESULT}"
            echo "Please enter a valid integer." >> "${RESULT}"
            echo "Enter integer #6: 60" >> "${RESULT}"
            echo "Enter integer #7: 70" >> "${RESULT}"
            echo "Enter integer #8: 80" >> "${RESULT}"
            echo "Enter integer #9: 19" >> "${RESULT}"
            echo "Enter integer #10: 100" >> "${RESULT}"
            echo "The average value is: 46.20" >> "${RESULT}"
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            printf "10\n20\n13\nfourty\n40\n50\nsixty\n6x\n60\n70\n80\n19\n100\n" | java -Djava.security.manager -Djava.security.policy="${SCRIPTDIR}/week11_policy" $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "#### data.txt" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            if [ -f data.txt ]; then
                cat data.txt >> "${RESULT}"
            else
                echo "File not found" >> "${RESULT}"
            fi
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh
