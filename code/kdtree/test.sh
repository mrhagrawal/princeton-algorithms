#!/bin/sh
for file in $(ls *Test.java); do
    javac $file
    java ${file%.*}
done
