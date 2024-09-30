# Java_labs

## Description (Lab1)

This repository contains Java lab work focused on matrix operations, such as matrix multiplication and calculating column averages. The project includes unit tests written using JUnit 4 to verify the correctness of the implemented operations.

## Requirements

- **Java Development Kit (JDK)** version 8 or higher
- **JUnit 4** for running the tests

## How to Run the Project

### 1. Clone the repository using the following command:

    ```bash
    git clone https://github.com/LiliaKozub/Java_labs.git
    cd Java_labs
    ```

### 2. Compile the Java files with this command:

    ```bash
    javac -d out/ src/lab_1/Main.java src/lab_1/MatrixOperations.java
    ```

### 3. Run the main application:

    ```bash
    java -cp out lab_1.Main
    ```

### 4. To run the unit tests, make sure you are in the `Java_labs` directory, then execute the following command:

    ```bash
    java -cp out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.MatrixOperationsTest
    ```
    ```bash
    java -cp out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.MainTest
    ```

## Conclusion

This project demonstrates the implementation of basic matrix operations and their validation through unit testing. Feel free to explore the code and make modifications as needed.

