#!/usr/bin/env bash

export JAVA_MODULES=(W1dot1 W1dot2 A1dot1 A1dot2 Main w1dot1 w1dot2 a1dot1 a1dot2)

function gradeModule() {
    java -Djava.security.manager $javaClass >> "${RESULT}" 2>&1
}

source $(dirname $0)/autograder_driver.sh