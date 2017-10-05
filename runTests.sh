#!/bin/bash
#! This runs a compiled JUnit Test
echo $1 
echo java -cp /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore 
java -cp /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore $1 > testResults.txt
