"""
Python Project 
Problem Statement: Smart Expense Tracker with Insights Many individuals struggle to track daily expenses and understand spending patterns. Build a Python application that allows users to log, categorize, and analyze their expenses. 

Objectives 
● Record daily expenses (date, category, amount, description) 
● Categorize spending (Food, Travel, Bills, etc.) 
● Generate monthly summaries and insights Key Features 
● CLI or simple GUI input system 
● Data storage using CSV or JSON 
● Monthly expense summary 
● Category-wise breakdown (pie chart using libraries like matplotlib) 
● Detect highest spending category 

Expected Outcome A tool that helps users understand where their money goes and suggests areas to reduce spending.
"""

import json, os
from datetime import datetime
from collections import defaultdict
import matplotlib.pyplot as plt

FILE = "expenses.json"
expenses = json.load(open(FILE)) if os.path.exists(FILE) else []

def save():
    json.dump(expenses, open(FILE, "w"), indent=2)

def add_expense():
    category = input("Category (Food/Travel/Bills/Shopping/Other): ").strip()
    amount = float(input("Amount: "))
    desc = input("Description: ").strip() or "No description"
    today = datetime.today().strftime("%d-%m-%Y")
    expenses.append({"date": today, "cat": category, "amt": amount, "desc": desc})
    save()
    print("Expense added successfully!\n")

def show_all():
    if not expenses:
        print("No expenses yet!\n")
        return
    print("\nYour Expenses:")
    for i, e in enumerate(expenses, 1):
        print(f"{i}. {e['date']} | {e['cat']} | ₹{e['amt']} | {e['desc']}")
    print()

def summary():
    if not expenses:
        print("No expenses yet\n")
        return
    
    totals = defaultdict(float)
    for e in expenses:
        totals[e["cat"]] += e["amt"]
    
    print("\nMonthly Summary")
    for cat, amt in totals.items():
        print(f"{cat}: ₹{amt:.2f}")
    print(f"Total Spent: ₹{sum(totals.values()):.2f}")
    print(f"Highest spending: {max(totals, key=totals.get)}")
    
    plt.pie(totals.values(), labels=totals.keys(), autopct="%1.1f%%")
    plt.title("Spending Breakdown")
    plt.show()

while True:
    print("1. Add Expense")
    print("2. View All")
    print("3. Summary & Chart")
    print("4. Exit")
    choice = input("Enter your choice: ").strip()
    
    if choice == "1": add_expense()
    elif choice == "2": show_all()
    elif choice == "3": summary()
    elif choice == "4":
        print("\nGoodbye")
        break
    else:
        print("Invalid choice\n")