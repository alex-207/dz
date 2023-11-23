#!/usr/bin/bash

if [ -e $1 ]; then
    if [ -d $1 ]; then
        rm -R *.bak *.tmp *.backup
        echo 'Done'
        exit 1
    fi
else
    echo 'ERROR: directory is not exist!'
    exit 2
fi
