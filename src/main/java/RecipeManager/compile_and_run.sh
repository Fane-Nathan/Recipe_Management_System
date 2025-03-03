#!/bin/bash

# Clean previous build
rm -rf out

# Compile all Java files
find src -name "*.java" > sources.txt
javac -d out @sources.txt

# Run program
java -cp out recipemanager.Main