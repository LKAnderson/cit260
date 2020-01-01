#!/usr/bin/env bash

export RESULT_TITLE="WEEK 13 FINAL PROJECT STRUCTURE"
export HAS_USERDIR_HOOK=1
export HAS_FINISHED_HOOK=1
export HAS_UML_DIAGRAM=1
export NO_COMPILE=1

function onUserDir() {
    export JAVA_MODULES=$(for f in $(ls -R | grep .java | grep -v .pdf | grep -v out | sort -u); do echo "${f%.*}"; done)
    rm -f data.txt strings.txt
}

function onFinished() {
    UMLS=$(find . -type f \( -name \*.puml -o -name \*.plantuml -o -name \*.pu \))
    if [ ${#UMLS[@]} -ne 0 ]; then
        echo "## UML Files" >> "${RESULT}"
        echo '<!-- UML-INJECT -->' >> "${RESULT}"
    fi
}

function gradeModule() {
    echo "" > /dev/null
}

source $(dirname $0)/autograder_driver.sh
