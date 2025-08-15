# Binary Search Tree Builder

A Spring Boot application that allows users to create binary search trees from a series of numbers, visualize the resulting tree structure, and view previously built trees.

## Project Overview

This application for our final project in DSA demonstrates the implmentation of a binary search tree with a server side rendered user interface using springboot and Thymeleaf. The user is able to visit "http://localhost:8080/enter-numbers", enter a sequence of numbers, and construct a binary search tree. This tree then gets displayed to the user in JSON format, and the users new tree and inputs for that tree are stored in a MySQL database. The user is also able to click "Show Previous Tress" which will display to the user the trees they created previously, along with the numbers they inputed to create the trees.

## Features

- **User Input Interface**: Web form for entering comma-separated numbers
- **BST Construction**: Automatically builds binary search trees from the users inputs
- **JSON Visualization**: Displays tree structure in JSON format
- **Database Persistence**: Stores all trees and input numbers for future reference
- **Tree History**: View all previously built trees with their input numbers and structures

## Technical Requirements

- Java 
- Spring Boot
- MySQL Database
- Maven
- Thymeleaf (for server-side rendering)

## How It Works

### 1. User Input
- Users visit "http://localhost:8080/enter-numbers" to access the input form
- Enter numbers separated by commas (e.g., "11, 22, 36, 49, 51, 65")

### 2. BST Construction
- Numbers are parsed and inserted sequentially into a binary search tree
- Tree is converted to JSON representation for the user to view

### 3. Data Storage
- Input numbers and tree structure are saved to MySQL database

### 4. Results Display
- Users see the constructed BST in JSON format
- Navigation options to build another tree or view history

### 5. Tree History
- Visit `/previous-trees` to see all previously built trees
- Each entry shows input numbers and complete tree structure

## How to run this project
- Make sure to clone this repo and open it using IntelliJ
- Create DB schema using MySQL workbench (DB schema should be dsa_final_2025)
- In the application.properties file, make sure the username and password matches your actual credentials
- Run "App.java" to start up the SpringBoot application
- Using a web browser of your choice, visit "http://localhost:8080/enter-numbers" and build your first tree
- Use the navigation buttons displayed on the page to build trees, and view previous trees and their inputs
