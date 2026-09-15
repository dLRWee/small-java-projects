#!/bin/bash

if [[ ! -d target ]]; then
	mkdir target
fi

if [[ ! -d target/bin ]]; then
	mkdir target/bin
fi

find src -name "*.java" > target/sources.txt

javac -d target/bin @target/sources.txt

java -cp target/bin Main
