#!/bin/bash
#! This compiles JUnit Tests
echo $1
echo javac -cp /usr/share/java/junit4.jar $1
javac -cp /usr/share/java/junit4.jar $1
