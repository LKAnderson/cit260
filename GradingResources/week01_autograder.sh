#!/usr/bin/env bash

export JAVA_MODULES=(A1dot1 A1dot2 A1dot3)

function gradeModule() {
    java $javaClass >> "${RESULT}" 2>&1
}

source $(dirname $0)/autograder_driver.sh