#!/usr/bin/env bash


export RESULT_TITLE="WEEK 3 PROGRAMMING EXERCISES"
export JAVA_MODULES=(W3dot1 w3dot1 A3dot1 a3dot1 W3dot2 w3dot2 A3d0t2 a3dot2)

function gradeModule() {
    case $module in 
        W3dot1|w3dot1|A3dot1|a3dot2)
            formattingDisclaimer
            output "<pre>"
            output "# Case 1: 0-Sunday + 3 = Wednesday"
            printf "0\n3\n" | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"
            
            output "<pre>"
            output "# Case 2: 0-Sunday + 15 = Monday"
            output ""
            printf "0\n15\n" | java -Djava.security.manager $module  >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"

            output "<pre>"
            output "# Case 3: 5-Friday + 21 = Friday"
            output ""
            printf "5\n21\n" | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"
            
            output "<pre>"
            output "# Case 4: 5 + -1 = Invalid"
            output ""
            printf '%d\n%d\n' 5 -1 | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"

            output "<pre>"
            output "# Case 5: 7 + -2 = Invalid"
            output ""
            printf '%d\n\%d\n' 7 -2 | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"
            ;;

        W3dot2|w3dot2|A3dot2|a3dot2)
            formattingDisclaimer
            output "<pre>"
            output "# Case 1: 2019 1 (Jan) =  31 days"
            output ""
            printf "2019\n1\n" | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"
            
            output "<pre>"
            output "# Case 2: 2019 2 (Feb) = 28 days"
            output ""
            printf "2019\n2\n" | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"
            
            output "<pre>"
            output "# Case 3: 2016 4 (Apr) = 30 days"
            output ""
            printf "2016\n4\n" | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"

            output "<pre>"
            output "# Case 4: 2000  2 (Feb) = 29 days"
            output ""
            printf "2000\n2\n" | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"

            output "<pre>"
            output "# Case 5: 1900 2 (Feb) = 28 days"
            output ""
            printf "1900\n2\n" | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"

            output "<pre>"
            output "# Case 6: 2020 -1 = Invalid"
            output ""
            printf "%d\n%d\n" 2020 -1 | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"

            output "<pre>"
            output "# Case 7: 2020 13 = Invalid"
            output ""
            printf "2020\n13\n" | java -Djava.security.manager $module >> "$$" 2>&1
            output $(cat "$$")
            rm "$$"
            output "</pre>"
            ;;
    esac
}

source $(dirname $0)/autograder_driver.sh