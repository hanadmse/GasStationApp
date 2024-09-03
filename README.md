## Fuel Track Application


Fuel Track is a fuel management system designed to track and manage fuel transactions, nozzle readings, and payments at a gas station. It allows users to monitor fuel usage, track sales data, and generate reports for better management and decision-making. In the current version, Fuel Track is implemented as a backend REST API built using Spring Boot and designed to receive information from the client in JSON format, making it easy for modern applications and front-end systems to interact with the backend REST API.

## Features

- Records, calculates, and analyzes financial data

- Monitors stock-sales variances, credit holder balances, fuel levels, and sales data.

- Track and manage fuel transactions


## Installation Guide: Prerequisites

- Java Development Kit (JDK): Ensure JDK 8 or later is installed.

- Maven: Installed and configured on your system.

- MySQL Database: Ensure MySQL is installed and running.

- IntelliJ IDEA or any IDE with Spring Boot support.

- Postman: Installed for API testing.


## Clone the Repository

- Open your terminal.

- Navigate to the directory where you want to clone the project.

- Clone the project and navigate into the project directory.


## Configure MySQL Database

- Create a new MySQL database.

- Update the application.properties or application.yml file in the src/main/resources directory with your MySQL database details.


## Build the Project

- In the terminal, run the following command to build the project: mvn clean install

- After a successful build, run the application using: mvn spring-boot:run


## Using Postman to Add Data from Client

9.) Open Postman and create a new POST request.

10.) Set the Request URL: Enter the URL of the Fuel Track API endpoint where you want to send data. For example, to add a new shift: http://localhost:8080/shiftId

11.) Set the Request Body: In the Body tab, select raw and choose JSON from the dropdown menu. Enter the JSON data for the fuel transaction in the request body. Example:
      { "date": "2024-08-31", 
        "shiftPeriod": "DAY"
      }
12.) Send the request and verify the data entry in MySQL

