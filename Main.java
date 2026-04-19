/* 
Java Project

Problem Statement: Library Management System
Libraries often face difficulty managing book inventory and issuing records manually. Develop a Java-based system to automate library operations.

Objectives
Manage books, users, and transactions
Track issued and returned books

Key Features
Add/remove/update books
User registration system
Issue and return books with due dates
Fine calculation for late returns
Search functionality (by title, author)
Technology Suggestions
Core Java (OOP concepts)
Optional: JDBC + MySQL for database integration
Simple console or GUI (Swing/JavaFX)
Expected Outcome
A functional system that reduces manual effort and improves tracking efficiency.
 */ 

import java.util.*;
class Main {
    static int[][] data = new int[100][3]; 
    static String[] bt = new String[100], ba = new String[100];
    static String[] uname = new String[100];
    static boolean[] avail = new boolean[100];
    static int bc = 0, uc = 0, rc = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    
        addBook("Book A", "Abel");
        addBook("Book B", "Robert");
        addBook("Book C", "Joel");
        uname[uc++] = "Rahul";
        uname[uc++] = "Priya";

        int ch;
        do {
            System.out.println("\n1.Books 2.AddBook 3.Users 4.AddUser 5.Issue 6.Return 7.Search 8.Records 0.Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt(); sc.nextLine();
            if (ch == 1) showBooks();
            else if (ch == 2) { System.out.print("Title: "); String t = sc.nextLine(); System.out.print("Author: "); addBook(t, sc.nextLine()); }
            else if (ch == 3) showUsers();
            else if (ch == 4) { System.out.print("Name: "); uname[uc++] = sc.nextLine(); System.out.println("User added!"); }
            else if (ch == 5) issueBook();
            else if (ch == 6) returnBook();
            else if (ch == 7) searchBook();
            else if (ch == 8) showRecords();
        } while (ch != 0);
        System.out.println("Bye");
    }

    static void addBook(String t, String a) {
        bt[bc] = t; ba[bc] = a; avail[bc++] = true;
        System.out.println("Book added");
    }

    static void showBooks() {
        System.out.println("\nID | Title            | Author       | Status");
        System.out.println("-".repeat(50));
        for (int i = 0; i < bc; i++)
            System.out.printf("%-3d| %-17s| %-13s| %s\n", i+1, bt[i], ba[i], avail[i] ? "Available" : "Issued");
    }

    static void showUsers() {
        System.out.println("\nID | Name");
        for (int i = 0; i < uc; i++)
            System.out.printf("%-3d| %s\n", i+1, uname[i]);
    }

    static void issueBook() {
        showBooks(); showUsers();
        System.out.print("Book ID: "); int b = sc.nextInt() - 1;
        System.out.print("User ID: "); int u = sc.nextInt() - 1;
        if (b < 0 || b >= bc || u < 0 || u >= uc) { System.out.println("Invalid!"); return; }
        if (!avail[b]) { System.out.println("Already issued!"); return; }
        avail[b] = false;
        data[rc][0] = b; data[rc][1] = u; data[rc][2] = -1; rc++;
        System.out.println(bt[b] + " issued to " + uname[u]);
    }

    static void returnBook() {
        System.out.print("Book ID: "); int b = sc.nextInt() - 1;
        System.out.print("User ID: "); int u = sc.nextInt() - 1;
        for (int i = 0; i < rc; i++) {
            if (data[i][0] == b && data[i][1] == u && data[i][2] == -1) {
                System.out.print("Days late: "); int d = sc.nextInt();
                data[i][2] = d; avail[b] = true;
                System.out.println("Returned Fine: Rs." + (d * 2));
                return;
            }
        }
        System.out.println("No record found!");
    }

    static void searchBook() {
        System.out.print("Keyword: "); String k = sc.nextLine().toLowerCase();
        for (int i = 0; i < bc; i++)
            if (bt[i].toLowerCase().contains(k) || ba[i].toLowerCase().contains(k))
                System.out.printf("ID:%d %s by %s [%s]\n", i+1, bt[i], ba[i], avail[i] ? "Available" : "Issued");
    }

    static void showRecords() {
        System.out.println("\nBook        | User   | Fine");
        System.out.println("-".repeat(35));
        for (int i = 0; i < rc; i++)
            System.out.printf("%-12s| %-7s| Rs.%d\n", bt[data[i][0]], uname[data[i][1]], data[i][2] * 2);
    }
}