#!/bin/bash
#! This runs a compiled JUnit Test
echo $1 
echo java -classpath bin/lca:/usr/share/java/junit4-4.12.jar:bin org.junit.runner.JUnitCore 
java -classpath bin/lca:/usr/share/java/junit4-4.12.jar:bin org.junit.runner.JUnitCore $1 > testResults.txt


