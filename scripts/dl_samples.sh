#! /bin/bash
problem=`echo "${PWD##*/}" | tr '[:upper:]' '[:lower:]'`
url="https://open.kattis.com/problems/$problem/file/statement/samples.zip"
curl $url > samples.zip
unzip samples.zip
rm samples.zip
