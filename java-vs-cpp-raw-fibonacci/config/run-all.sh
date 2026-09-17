#!/bin/bash

# Arg Validation

if ! [[ "$1" =~ ^[0-9]+$ ]]; then
	echo "[ERROR] index must be a non-negative integer"
    	echo "usage: <index>"
	exit 1
fi

# Constants

readonly JAVA_OUTPUT="bin/java"
readonly CPP_OUTPUT="bin/cpp"

readonly CPP_COMPILATION_FLAGS="-Ofast -march=native -flto"
readonly JAVA_EXECUTION_FLAGS="-Xcomp -XX:TieredStopAtLevel=1 -Xms64m -Xmx64m"

# Directories Creation

if [[ ! -d bin ]]; then
	mkdir bin
fi

if [[ ! -d bin/java ]]; then
	mkdir bin/java
fi

if [[ ! -d bin/cpp ]]; then
	mkdir bin/cpp
fi

# Compilation

javac -d $JAVA_OUTPUT src/java/Main.java
g++ $CPP_COMPILATION_FLAGS src/cpp/Main.cpp -o ${CPP_OUTPUT}/Main.out

# Execution

echo "===== C++ ======"
time ./bin/cpp/Main.out "$@"

echo -e "----------------\n"

echo "===== Java ====="
time java $JAVA_EXECUTION_FLAGS -cp bin/java Main "$@"

echo -e "----------------"
