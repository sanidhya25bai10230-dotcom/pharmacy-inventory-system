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



## Requirements

To run this project, make sure you have:
* **Java Development Kit (JDK):** Version 11 or higher installed on your computer.
* **Terminal or Command Prompt** (or the integrated terminal in VS Code).






