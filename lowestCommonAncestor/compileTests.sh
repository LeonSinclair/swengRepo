#!/bin/bash
# This compiles JUnit Tests
# Takes a single argument of the form packagename/filename.java
echo $1
echo javac -d bin -classpath bin:/usr/share/java/junit4.jar -sourcepath src $1
javac -d bin -classpath bin:/usr/share/java/junit4.jar -sourcepath src src/$1
