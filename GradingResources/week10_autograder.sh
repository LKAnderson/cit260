#!/usr/bin/env bash

export RESULT_TITLE="WEEK 10 PROGRAMMING EXERCISE"
export JAVA_MODULES=(W10dot1 w10dot1 A10dot1 a10dot1 Triangle GeometricObject)
export HAS_UML_DIAGRAM=1
export HAS_FINISHED_HOOK=1

function onFinished() {
    UMLS=$(find . -type f \( -name \*.puml -o -name \*.plantuml -o -name \*.pu \))
    if [ ${#UMLS[@]} -ne 0 ]; then
        output "<h2>UML Files</h2>"
        output '<!-- UML-INJECT -->'
    fi
}

function gradeModule() {

    case $module in

        *10*ot1)
            # Figure out whether they've coded it to read the sides or the color first.
            firstDouble=$(grep -n -e "nextInt()\|nextDouble()" $javaFile | head -n 1 | sed 's/:.*//')
            firstInt=$(grep -n "nextInt()" $javaFile | head -n 1 | sed 's/:.*//')
            firstLine=$(grep -n "nextLine()" $javaFile | head -n 1 | sed 's/:.*//')

            output "<h4>Case 1</h4>"
            output "<h5>Inputs</h5>"
            output "<pre>"
            if [ $firstDouble -lt $firstLine ]; then
                output "Triangle 1: 3 4 5   blue   y "
                output "Triangle 2: 6 7 8   red    n "
                output "Triangle 3: 9 10 11 yellow y "
            else
                output "Triangle 1: blue   y  3 4 5"
                output "Triangle 2: red    n  6 7 8"
                output "Triangle 3: yellow y  9 10 11"
            fi
            output "</pre>"
            output "<h5>Expected</h5>"
            output "<pre>"
            output "Side1: 3.00, Side2: 4.00, Side3: 5.00"
            output "Created on Sat Nov 23 18:54:30 CST 2019"
            output "color: blue and filled: true"
            output "The area is: 6.00"
            output ""
            output "Side1: 6.00, Side2: 7.00, Side3: 8.00"
            output "Created on Sat Nov 23 18:54:49 CST 2019"
            output "color: red and filled: false"
            output "The area is: 20.33"
            output ""
            output "Side1: 9.00, Side2: 10.00, Side3: 11.00"
            output "Created on Sat Nov 23 18:55:10 CST 2019"
            output "color: yellow and filled: true"
            output "The area is: 42.43"
            output "</pre>"
            output "<h5>Your Output</h5>"
            output "<pre>"
            if [ $firstDouble -lt $firstLine ]; then
                output "$(printf "3 4 5\nblue\ny\n6 7 8\nred\nn\n9 10 11\nyellow\ny\n" | java -Djava.security.manager $module 2>&1)" 
            else
                output "$(printf "blue\ny\n3 4 5\nred\nn\n6 7 8\nyellow\ny\n9 10 11\n" | java -Djava.security.manager $module 2>&1)" 
            fi
            output "</pre>"

            output "<h4>Case 2</h4>"
            output "<h5>Inputs</h5>"
            output "<pre>"
            if [ $firstDouble -lt $firstLine ]; then
                output "3 4 5 &lt;empty color&gt; y "
            else
                output "&lt;empty color&gt; y 3 4 5"
            fi
            output "</pre>"
            output "<h5>Expected</h5>"
            output "An error should be reported"
            output "<h5>Your Output</h5>"
            output "<pre>"
            if [ $firstDouble -lt $firstLine ]; then
                output "$(printf "3 4 5\n\ny\n" | java -Djava.security.manager $module 2>&1)"
            else
                output "$(printf "\ny\n3 4 5\n" | java -Djava.security.manager $module 2>&1)"
            fi
            output "</pre>"

            output "<h4>Case 3</h4>"
            output "<h5>Inputs</h5>"
            output "<pre>"
            if [ $firstDouble -lt $firstLine ]; then
                output "-3 4 5 blue y"
            else 
                output "blue y -3 4 5"
            fi
            output "</pre>"
            output "<h5>Expected</h5>"
            output "An error should be reported"
            output "<h5>Your Output</h5>"
            output "<pre>"
            if [ $firstDouble -lt $firstLine ]; then
                output "$(printf "%d 4 5\nblue\ny\n" -3 | java -Djava.security.manager $module 2>&1)"
            else
                output "$(printf "blue\ny\n%d 4 5\n" -3 | java -Djava.security.manager $module 2>&1)"
            fi 
            output "</pre>"
            ;;

    esac
}

source $(dirname $0)/autograder_driver.sh