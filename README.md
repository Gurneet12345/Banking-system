# ATM Simulator System

## Project Overview

This project is an ATM Simulator System developed in Java. It provides a simulated environment to mimic basic ATM functionalities such as balance inquiry, withdrawal, deposit, and more. The project is structured as a Java application with a comprehensive set of features typically expected in an ATM system.

## Project Structure

Here is an overview of the main components of the project:

### 1. Root Directory

- **.classpath**: Configuration file used by Eclipse IDE for managing project classpath.
- **.project**: Project description file for Eclipse IDE.
- **ATM**: Main project folder containing the source code and build files.

### 2. ATM/ATM-Simulator-System

This is the main folder where the core ATM Simulator System resides.

- **build.xml**: Ant build script used to compile and package the project.
- **manifest.mf**: Manifest file containing meta-information about the project.
- **nbproject**: NetBeans project folder containing configuration and project properties.

### 3. Source Code (`src/ASimulatorSystem`)

The source code of the ATM Simulator System is located in the `src/ASimulatorSystem` directory. Below are the key Java files:

- **BalanceEquiry.java**: Handles the balance inquiry functionality of the ATM system.
- **Conn.java**: Manages database connections used across the application.
- **Deposit.java**: Implements the deposit functionality.
- **FastCash.java**: Facilitates quick cash withdrawal options.
- **Login.java**: Handles the login process for users.
- **MiniStatement.java**: Provides a mini statement of recent transactions.
- **Pin.java**: Manages PIN change operations.
- **Practice.java**: A practice class, likely used for testing or prototyping.
- **Signup.java**: Handles user registration (part 1).
- **Signup2.java**: Handles additional details for user registration (part 2).
- **Signup3.java**: Finalizes the user registration process (part 3).
- **Transactions.java**: Manages user transactions within the ATM system.
- **Withdrawl.java**: Implements the withdrawal functionality.

### 4. Icons (`src/ASimulatorSystem/icons`)

This directory contains the image resources (icons) used in the application, providing visual elements for the user interface.

## How to Build and Run

To compile and run the project:

1. **Using NetBeans IDE**:
   - Open the project in NetBeans.
   - Build and run the project directly using the IDE's run configurations.

2. **Using Command Line with Ant**:
   - Navigate to the `ATM/ATM-Simulator-System` directory.
   - Run the command `ant` to compile and build the project using the `build.xml` script.
   - Execute the generated `.jar` file or run the application via the command line.

## Additional Documentation

For more detailed information, refer to the following files provided in the root directory:

- **Readme.md**: (This file) Provides an overview of the project.
- **PatchNotes.md**: Contains the release notes and updates for the project.
- **Projects.md**: Details the various projects and modules included in this repository.
- **Part1.md to Part9.md**: Sequential documentation files that cover different parts of the project in detail.
- **Interludes.md**: Additional documentation or notes that provide context or background information.

# Client-Server Banking System

## Overview

This project implements a client-server banking system using Java. The system allows clients to connect to a central server to perform basic banking operations such as creating accounts, depositing, withdrawing, and checking balances.

**Note**: There are known issues and errors in the code. Please refer to the sections below for details on how to identify and address these errors.

## Project Structure

- **Client.java**: Implements the client-side application that interacts with the server.
- **Server.java**: Implements the server-side application that manages multiple clients.
- **Database.java**: Handles the storage and retrieval of account data.
- **Account.java**: Manages individual bank account operations.
- **Person.java**: Represents a customer in the banking system.
- **Main1.java**: Main entry point for the application (Server-side).
- **Main2.java**: Another main entry point (Client-side).
- **RandomNums.java**: Utility class for generating random numbers.
- **ServerThread.java**: Manages concurrent client connections on the server side.

## Known Issues

1. **Compilation Errors**:
   - There may be errors in the source files that prevent successful compilation. These could be due to missing libraries, syntax issues, or incorrect logic.

2. **Runtime Errors**:
   - Even if the code compiles, some functions may not work as expected during runtime. This could manifest as unexpected behavior, crashes, or incorrect outputs.

3. **Logical Errors**:
   - The code may contain logical errors that do not produce any immediate crashes but result in incorrect processing or data handling.

## Steps to Troubleshoot

1. **Check Compilation**:
   - Compile the code in your IDE or using the command line to identify any immediate syntax or library-related issues.

2. **Debugging**:
   - Use debugging tools available in your IDE to step through the code and identify the sources of runtime errors.
   - Add print statements or use a logging framework to trace the flow of the application and isolate problematic sections.

3. **Review Logic**:
   - Manually review the code logic, especially in critical sections like `Account.java`, `Database.java`, and `Client.java`, to ensure that operations are performed as expected.

## How to Run

1. **Setup the Environment**:
   - Ensure you have Java installed on your system.
   - Set up your IDE (Eclipse recommended) and import the project.

2. **Running the Server**:
   - Compile and run the `Server.java` file. This will start the server and wait for client connections.

3. **Running the Client**:
   - Compile and run the `Client.java` file. This will start the client and connect it to the server.

4. **Operations**:
   - Once connected, you can create accounts, deposit, withdraw, and check balances using the client application.

**Note**: Due to the known errors, some of these operations may not work as intended.

## Requirements

- **Java 8 or higher**: Ensure you have a compatible version of Java installed.
- **Eclipse IDE**: Recommended for project setup and management.

## Future Improvements

- Debug and fix the identified issues.
- Implement more advanced banking operations.
- Add a graphical user interface (GUI).
- Implement secure communication between the client and server.

## Additional Documentation

Refer to the following files provided in the root directory for more information:

- **Readme.md**: (This file) Provides an overview of the project.
- **PatchNotes.md**: Contains the release notes and updates for the project.
- **Projects.md**: Details the various projects and modules included in this repository.
- **Part1.md to Part9.md**: Sequential documentation files that cover different parts of the project in detail.
- **Interludes.md**: Additional documentation or notes that provide context or background information.
