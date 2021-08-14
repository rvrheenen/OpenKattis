#!/bin/bash
# when sourcing or running in the directory, make sure to add the .
# ie: source ./set_aliases.sh

SCRIPT_DIR=$( cd ${0%/*} && pwd -P )

alias dl_samples="${SCRIPT_DIR}/dl_samples.sh"
alias iocheck_c="${SCRIPT_DIR}/iocheck_c.sh"
alias iocheck_cpp="${SCRIPT_DIR}/iocheck_cpp.sh"
alias iocheck_java="${SCRIPT_DIR}/iocheck_java.sh"
alias iocheck_python="${SCRIPT_DIR}/iocheck_python.sh"
alias iocheck_rust="${SCRIPT_DIR}/iocheck_rust.sh"
