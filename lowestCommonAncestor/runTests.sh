#!/bin/bash
# This runs a compiled JUnit Test
# Takes a single argument of the form packagename.filename
echo java -classpath /usr/share/java/junit4-4.12.jar:bin org.junit.runner.JUnitCore $1
java -classpath /usr/share/java/junit4-4.12.jar:bin org.junit.runner.JUnitCore $1 > testResults.txt


