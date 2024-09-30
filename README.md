# Java_labs

## Description (Lab1)

This repository contains Java lab work focused on matrix operations, such as matrix multiplication and calculating column averages. The project includes unit tests written using JUnit 4 to verify the correctness of the implemented operations.

## Requirements

- **Java Development Kit (JDK)** version 8 or higher
- **JUnit 4** for running the tests

## How to Run the Project

### 1. Clone the Repository

To get started, clone the repository using the following command:

```bash
git clone https://github.com/LiliaKozub/Java_labs.git
cd Java_labs
```

### 2. Compile the Project

Compile the Java files with this command:

```bash
javac -d out/ src/main/java/MatrixOperations.java src/main/java/Main.java
```

### 3. Run the Project

To run the project, use the following command:

```bash
java -cp out Main
```

### 4. Run Unit Tests

To run the unit tests, use the following command:

```bash
javac -d out/ -cp junit-4.12.jar src/test/java/MatrixOperationsTest.java
java -cp out/:junit-4.12.jar org.junit.runner.JUnitCore MatrixOperationsTest
```

## Conclusion

This project demonstrates basic matrix operations and their implementation in Java. The provided tests ensure the correctness of the operations. Feel free to explore and modify the code as needed.

