#!/bin/bash
#This compiles standard Java files.
#Takes a single argument of the form packagename/filename.java
echo $1
echo javac -d bin -classpath bin -sourcepath src $1
javac -d bin -classpath bin -sourcepath src src/$1