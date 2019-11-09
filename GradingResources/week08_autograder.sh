#!/usr/bin/env bash

export RESULT_TITLE="WEEK 8 PROGRAMMING EXERCISES"
export JAVA_MODULES=(Rectangle W8dot1 w8dot1 W08dot1 W8dot2 w8dot2 W08dot2)
export HAS_USERDIR_HOOK=1
export HAS_HTML_EXTRA=1


function onUserDir() {
    # Look for any PDF files outside of our directory and copy them in.
    for pdf in $(ls ../${userdir}*.pdf 2> /dev/null); do
        echo "Copying $pdf into working directory"
        cp $pdf .
    done

    echo "<h2>Additional Files</h2>" > ${HTML_EXTRA}

    # find plantuml files and convert them to svg
    for uml in $(find . -name \*uml -o -name \*.pu); do 
        echo "Found PlantUML file: ${uml}"
        svg=$(basename $uml).svg
        curl -s https://www.plantuml.com/plantuml/svg/$(${SCRIPTDIR}/plantuml-encode "${uml}") > "${svg}"    
        cat <<EOHTML >> ${HTML_EXTRA}
            <h3>${uml}</h3>
            <table><tr><td>
            $(cat ${svg})
            </td><td>
            <pre>$(cat ${uml})</pre>
            </td></tr></table>
EOHTML
        rm ${svg}
    done

    # Find any other image files (png, jpg, jpeg, gif)
    for img in $(find . -name \*.png -o -name \*.jpg -o -name \*.jpeg -o -name \*.gif); do
        echo "Found image file: ${img}"
        cat <<EOHTML >> ${HTML_EXTRA}
            <h3>${img}</h3>
            <img src="${img}"/>
EOHTML
    done

    for pdf in $(find . -name \*.pdf | grep -v feedback); do 
        echo "Found pdf file: ${pdf}"
        cleanpdf=$(echo "$pdf" | sed 's/^\.\///' | sed 's/ /+/')
        cat <<EOHTML >> ${HTML_EXTRA}
            <h3>${pdf}</h3>
            <p>
            <em>Please review this file separate as it cannot be rendered in this document.</em>
            </p>
EOHTML
    done
}

function gradeModule() {

    case $module in

        W8dot1|w8dot1|W08dot1)
            echo "### Expected Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "rectangle1: width: 40.00, height: 4.00, area; 160.00, permiter: 88.00" >> "${RESULT}"
            echo "rectangle2: width: 5.00, height: 3.50, area; 17.50, permiter: 17.00" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;

        W8dot2|w8dot2|W08dot2)
            echo "### Expected Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            echo "A description of the program" >> "${RESULT}"
            echo "" >> "${RESULT}"
            echo "Wed Dec 31 17:00:10 MST 1969" >> "${RESULT}"
            echo "Wed Dec 31 17:01:40 MST 1969" >> "${RESULT}"
            echo "Wed Dec 31 19:46:40 MST 1969" >> "${RESULT}"
            echo "Thu Jan 01 20:46:40 MST 1970" >> "${RESULT}"
            echo "Mon Jan 12 06:46:40 MST 1970" >> "${RESULT}"
            echo "Sun Apr 26 10:46:40 MST 1970" >> "${RESULT}"
            echo "Sat Mar 03 02:46:40 MST 1973" >> "${RESULT}"
            echo '```' >> "${RESULT}"
            echo "### Actual Output" >> "${RESULT}"
            echo '```plaintext' >> "${RESULT}"
            java -Djava.security.manager $module >> "${RESULT}" 2>&1; 
            echo '' >> "${RESULT}"
            echo '```' >> "${RESULT}"
            ;;

    esac
}

source $(dirname $0)/autograder_driver.sh