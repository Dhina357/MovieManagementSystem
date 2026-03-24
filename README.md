# 🎬 Movie Management System – Console-Based Java Project

## Overview
This is a **Java console-based application** that manages movies, showtimes, and ticket bookings.  
It supports multiple user roles: **Admin, Staff, and Customer**, each with specific permissions.  
The project demonstrates **object-oriented programming**, **role-based access**, and **data handling** in Java.

---

## Features

### Admin
- Add, view, and delete movies  
- View all bookings  
- Filter bookings by movie, customer, or date  
- Input validation for movie details

### Staff
- Schedule, update, and cancel movie shows  
- View all shows with Show ID, date, time, and available seats  
- Input validation and error handling

### Customer
- View and edit profile  
- Browse movies and available shows  
- Book tickets and view booking history  
- View active bookings and balance

### Common
- User registration with auto-generated **User ID**  
- Role-based login and access control  
- Console-based interactive menus  

---

## Technologies & Concepts
- **Language:** Java  
- **OOP Concepts:** Classes, Objects, Encapsulation, Static members  
- **Collections:** ArrayList for storing users, movies, shows, and bookings  
- **Error Handling:** Try-catch and input validation  
- **Role-Based Access Control**  
- **Console-Based Menu Design**
- 


---

## Project Structure
MovieManagementSystem/
├── app/
│   └── Main.java                 # Entry point of the application
├── models/                       # Data models / entities
│   ├── User.java                 # User class with ID, name, email, role
│   ├── Movie.java                # Movie class with ID, title, genre, etc.
│   ├── Show.java                 # Show class with ID, movie ID, date, time, seats
│   └── Booking.java              # Booking class linking user ID and show ID
├── services/                     # Business logic / role-based operations
│   ├── AdminService.java         # Admin operations (add/view/delete movies, view bookings)
│   ├── StaffService.java         # Staff operations (schedule/update/cancel shows)
│   ├── CustomerService.java      # Customer operations (profile, book tickets, view history)
│   └── AuthService.java          # User registration and login
└── utils/                        # Utility/helper classes
    └── Validation.java           # Input validation (dates, ratings, IDs, etc.)
---

## How It Works
1. Users register with name, email, password, and role (Admin/Staff/Customer)  
2. Users log in with email and password  
3. Role-specific menus are displayed:  
   - Admin: manage movies and bookings  
   - Staff: schedule and manage shows  
   - Customer: book tickets and view profile/history  

---

## Running the Project
1. Clone the repository:
```bash
git clone <your-repo-url>
---
2 . Navigate to project root:
cd MovieManagementSystem
Compile all Java files:
javac app/Main.java models/*.java services/*.java utils/*.java
Run the project:
java app.Main
Topics Covered
Topic	Description
Java Basics	Variables, loops, conditionals, Scanner input
OOP	Classes, Objects, Constructors, Encapsulation
Collections	ArrayList for dynamic data storage
Role-Based Access	Different menus and permissions for Admin, Staff, Customer
Input Validation	Numeric and string validations, future date checks
Booking System Logic	Linking bookings to users and shows via IDs
Error Handling	Try-catch, invalid input prevention
Console UI	Interactive menu-driven design
