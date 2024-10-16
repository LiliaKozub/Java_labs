# Java_labs

## Description (Lab1, variant 9)

This repository contains Java lab work focused on matrix operations, such as matrix multiplication and calculating column averages. The project includes unit tests written using JUnit 4 to verify the correctness of the implemented operations.

## Requirements

- **Java Development Kit (JDK)** version 8 or higher
- **JUnit 5** for running the tests

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

    
    javac -cp "../out/production/untitled/lab_1;C:/path_to_libs/junit-jupiter-api-5.7.0.jar;C:/path_to_libs/hamcrest-core-1.3.jar" tests/*.java -d ../out/test/untitled

    

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
     

### 3. Compile and package the project with Maven


     mvn clean package


### 4. Run the compiled JAR file:


     java -jar target/untitled2-1.0-SNAPSHOT.jar


### 5. To run the tests, use:


     mvn test


## Conclusion

This project demonstrates the ability to manipulate strings and count word occurrences across sentences using Java. 


## Description (Lab3, variant 9)

This lab implements an NPC character management system for games. The project allows you to create, save and sort NPCs by various criteria such as name, role, level and agility. The user can enter details for each NPC, view a list of created characters, and search for identical NPCs in the list.

## Requirements

- **Java Development Kit (JDK)** version 11 or higher
- **JUnit 5** for running the tests
- **Apache Maven** 3.6.0 or higher

## How to Run the Project

### 1. Clone the repository using the following command:

    
    git clone https://github.com/LiliaKozub/Java_labs.git
    

### 2. Navigate to the lab3_java directory


     cd Java_labs/lab3_java
     

### 3. Compile and package the project with Maven


     mvn clean package


### 4. Run the compiled JAR file:


     java -jar target/untitled2-1.0-SNAPSHOT.jar


### 5. To run the tests, use:


     mvn test


## Documentation

The project documentation can be viewed at the following link: [Documentation](https://regal-douhua-668122.netlify.app/).

## Conclusion

This lab work demonstrates the effective use of object-oriented programming principles in Java to manage game entities, specifically Non-Playable Characters (NPCs).
