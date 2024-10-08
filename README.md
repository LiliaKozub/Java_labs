# Java_labs

## Description (Lab1, variant 9)

This repository contains Java lab work focused on matrix operations, such as matrix multiplication and calculating column averages. The project includes unit tests written using JUnit 4 to verify the correctness of the implemented operations.

## Requirements

- **Java Development Kit (JDK)** version 8 or higher
- **JUnit 4** for running the tests

## How to Run the Project

### 1. Clone the repository using the following command:

    
    git clone https://github.com/LiliaKozub/Java_labs.git
    cd Java_labs
    cd lab1_java

### 2. Compile the Java files with this command:

    
    javac -d out/ src/lab_1/Main.java src/lab_1/MatrixOperations.java
    

### 3. Run the main application:

    
    java -cp out lab_1.Main
    

### 4. To run the unit tests, make sure you are in the `Java_labs` directory, then execute the following command:

    
    java -cp out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.MatrixOperationsTest
    
    
    java -cp out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.MainTest
    

## Conclusion

This project demonstrates the implementation of basic matrix operations and their validation through unit testing. 

## Description (Lab2, variant 9)

This project involves creating a Java class that includes an executable method designed to perform actions on a given text string and an array of words. The main objective is to count how many sentences contain each word from the array

## Requirements

- **Java Development Kit (JDK)** version 8 or higher
- **JUnit 5** for running the tests
- **Apache Maven** 3.6.0 or higher

## How to Run the Project

### 1. Clone the repository using the following command:

    
    git clone https://github.com/LiliaKozub/Java_labs.git
    

### 2. Navigate to the lab2_java directory


     cd Java_labs/lab2_java
     

### 3. Build the project with Maven


     mvn clean install


### 4. To run the project, use the following Maven command:


     mvn exec:java -Dexec.mainClass="org.example.Main"


### 5. To run the tests, use:


     mvn test


