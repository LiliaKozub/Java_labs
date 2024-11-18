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
    

### 4. To run the unit tests, make sure you have the `Java_labs` directory, then:
To run the tests, open the project directory through the IDE. In IntelliJ IDEA, you can simply right-click on the test directory or individual test classes in the tests folder and select Run 'All Tests' or Run 'TestName'.

## Conclusion

This project demonstrates the implementation of basic matrix operations and their validation through unit testing. 

<br>

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

<br>

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

<br>

## Description (Lab4)

This project is focused on processing text elements such as sentences, words, punctuation, and letters. The main functionality includes counting the number of occurrences of specific words in a set of sentences. The project also includes a set of unit tests to verify the correctness of the implementation. 

## Requirements

- **Java Development Kit (JDK)** version 11 or higher
- **JUnit 5** for running the tests
- **Apache Maven** 3.6.0 or higher

## How to Run the Project

### 1. Clone the repository using the following command:

    
    git clone https://github.com/LiliaKozub/Java_labs.git
    

### 2. Navigate to the project directory


     cd Java_labs/lab4_java
     

### 3. Build the project


     mvn clean package


### 4. Run the project:


     java -jar target\lab4_java-1.0-SNAPSHOT.jar


### 5. To run the tests, use:


     mvn test


## Documentation

The project documentation can be viewed at the following link: [Documentation](https://effervescent-frangipane-8380b4.netlify.app/).

## Conclusion

This lab demonstrates how to implement a program that processes text elements using object-oriented principles in Java. 

<br>

## Description (Lab5, variant 9)

The lab work involved creating a passenger car management system by implementing an inheritance hierarchy for passenger cars.The program shows the taxi fleet class, which is an array of passenger cars, and the class performs such actions as calculating the cost of the fleet, sorting the fleet cars by fuel consumption, searching for a car that corresponds to a given speed range. 

## Requirements

- **Java Development Kit (JDK)** version 11 or higher
- **JUnit 5** for running the tests
- **Apache Maven** 3.6.0 or higher

## How to Run the Project

### 1. Clone the repository using the following command:

    
    git clone https://github.com/LiliaKozub/Java_labs.git
    

### 2. Navigate to the project directory


     cd Java_labs/lab5_java
     

### 3. Build the project


     mvn clean package


### 4. Run the project:


     java -jar target\lab5_java-1.0-SNAPSHOT.jar


### 5. To run the tests, use:


     mvn test


## Documentation

The project documentation can be viewed at the following link: [Documentation](https://singular-heliotrope-f5ae69.netlify.app/).

## Conclusion

In conclusion, the lab work successfully implemented a passenger car management system through an inheritance hierarchy.

<br>

## Description (Lab6, variant 9)

This laboratory work is aimed at the development and testing of a data structure for storing cars in the form of a set (Set), which allows you to perform operations of adding, deleting, checking the presence of elements, checking the size of the set, etc., and also supports the uniqueness of elements. The work includes creating a CarSet class that implements a set of cars, as well as testing its functionality using JUnit tests.

## Requirements

- **Java Development Kit (JDK)** version 11 or higher
- **JUnit 5** for running the tests
- **Apache Maven** 3.6.0 or higher

## How to Run the Project

To quickly test the basic operation of the CarSet class, you can run the main method in the Main class, which contains the implementation and demonstration of the operation of the car set. This will allow you to test basic functions such as adding cars to a set, removing them, checking for items, set size, etc.

### 1. Clone the repository using the following command:

    
    git clone https://github.com/LiliaKozub/Java_labs.git
    

### 2. Navigate to the project directory


     cd Java_labs/lab6_java
     

### 3. Build the project


     mvn clean package


### 4. Run the project:


     java -jar target\lab6_java-1.0-SNAPSHOT.jar

## How to Run the tests

For more in-depth verification of the operation of each method in the CarSet class, you can use tests that check all possible operations with a set of cars. The tests are written using JUnit 5 and cover all the functionality of the CarSet class

### 5. To run the tests, use:


     mvn test


## Documentation

The project documentation can be viewed at the following link: [Documentation](https://glistening-dodol-e0a3d0.netlify.app/).

## Conclusion

As a result of the laboratory work, the CarSet class was developed, which implements a set of cars with the ability to perform standard operations, such as adding, removing, checking the presence of elements, as well as maintaining the uniqueness of data. Due to the use of arrays for storing elements, an automatic change in the size of the array was implemented when adding new elements. In addition, the functionality of the class was tested using JUnit, which allowed to check the correct implementation of the methods.

