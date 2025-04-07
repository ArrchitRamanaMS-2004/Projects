create database FMSDB;
USE fmsdb;

-- Users Table
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);


-- ExpenseCategories Table
CREATE TABLE ExpenseCategories (
    category_id INT PRIMARY KEY ,
    category_name VARCHAR(100) UNIQUE NOT NULL
);


-- Expenses Table
CREATE TABLE Expenses (
    expense_id INT PRIMARY KEY ,
    user_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    category_id INT NOT NULL,
    expense_date DATE NOT NULL,
    expense_description TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES ExpenseCategories(category_id) ON DELETE RESTRICT
);

