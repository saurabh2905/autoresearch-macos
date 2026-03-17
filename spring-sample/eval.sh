#!/bin/bash
# eval.sh: Compiles, Tests, and Measures JAR size.

# 1. Clean and Compile (ensures no ghost dependencies)
mvn clean package -DskipTests > /dev/null 2>&1
if [ $? -ne 0 ]; then
    echo "BUILD_FAILED"
    exit 1
fi

# 2. Run Tests (the validation step)
mvn test > /dev/null 2>&1
if [ $? -ne 0 ]; then
    echo "TESTS_FAILED"
    exit 1
fi

# 3. Measure Size in Bytes (The Score)
# Adjust the path to your actual JAR name
JAR_PATH=$(ls target/*.jar | head -n 1)
SIZE=$(stat -f%z "$JAR_PATH") 
echo "SCORE:$SIZE"