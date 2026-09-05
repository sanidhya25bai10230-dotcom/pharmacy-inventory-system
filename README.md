# Pharmacy Inventory Management System

A simple, easy-to-use Java program to manage pharmacy stock, sell medicines, calculate bills and track expired items directly from your computer terminal.



## What This Project Does

Managing a pharmacy manually can lead to mistakes like running out of stock or selling expired medicine. This project provides a simple terminal tool to keep track of everyday pharmacy tasks:
* Store information about medicines (name, batch number, price, quantity, expiry date and medicine type).
* Sell medicines and automatically calculate total bills with tax.
* Warn the user when medicine stock is running low (5 or fewer units left).
* Flag medicines that are past their expiration date.
* Automatically save all records into a local file so data is never lost when you close the program.



## Features

* **Medicine Management:** Add new medicines, view current stock and update quantities anytime.
* **Smart Categorization:** Uses Java OOP concepts to separate **Prescription** medicines from **Over-The-Counter (OTC)** medicines.
* **Billing System:** Handles customer orders, deducts purchased items from stock and adds a 5% tax.
* **Safety Checks:** Uses custom Java exceptions to stop sales if an item does not exist or if there is not enough stock.
* **Automatic File Saving:** Saves and loads everything using a CSV file without needing complex databases.
* **Pure Command Line:** Runs entirely in the terminal with zero external tools.



## Technologies Used

To run this project, make sure you have:
* **Java Development Kit (JDK):** Version 11 or higher installed on your computer.
* **Terminal or Command Prompt** (or the integrated terminal in VS Code).




## Steps to Install & Run the Project

### 1. Open the project folder
Open your terminal and move to your project folder

cd pharmacy-inventory-system



## Instructions for Testing

1. Add a medicine
   * Enter 2 in the terminal
   * Enter ID: M101
   * Enter Name: Paracetamol
   * Enter Batch Number: B01
   * Enter Unit Price: 5.0
   * Enter Quantity: 20
   * Enter Expiry Date: 2027-12-31
   * Enter Prescription only: n

2. View stock
   * Enter 1 in the terminal to view all items and check if M101 appears

3. Check file storage
   * Look inside the data folder to confirm medicines.csv has been created

4. Test billing
   * Enter 4 in the terminal
   * Enter ID: M101
   * Enter Quantity: 2
   * Confirm the total is 10.50 and stock reduces to 18

5. Test stock error check
   * Enter 4 in the terminal
   * Enter ID: M101
   * Enter Quantity: 50
   * Confirm that an error shows up and the app does not crash

6. Test invalid ID
   * Enter 4 in the terminal
   * Enter ID: M999
   * Enter Quantity: 1
   * Confirm that a medicine not found message appears

7. Test alerts
   * Enter 5 in the terminal to see low stock and expired items

8. Exit the app
   * Enter 6 in the terminal to close the program






