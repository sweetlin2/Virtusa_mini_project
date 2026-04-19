/*
SQL Project
Problem Statement: Online Retail Sales Analysis Database
Retail businesses generate huge sales data but lack structured insights. Design a database and write SQL queries to analyze sales performance.

Objectives
Create a relational database for an online store
Store customer, product, and order data
Extract meaningful insights using SQL queries
Database Tables
Customers (customer_id, name, city)
Products (product_id, name, category, price)
Orders (order_id, customer_id, date)
Order_Items (order_id, product_id, quantity)

Key Tasks
Find top-selling products
Identify most valuable customers
Monthly revenue calculation
Category-wise sales analysis
Detect inactive customers
Expected Outcome
A structured database with optimized queries that provide actionable business insights.
*/

-- DATABASE SCHEMA

CREATE DATABASE retail_db;
USE retail_db;

-- Customers table 
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    city VARCHAR(50)
);

-- Products table
CREATE TABLE Products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10,2)
);

-- Orders table
CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Order items table
CREATE TABLE Order_Items (
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);