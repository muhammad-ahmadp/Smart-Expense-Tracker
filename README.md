# Smart Expense Tracker

A console-based financial management system designed for personal expense tracking, budget monitoring, and spending analysis. This project demonstrates the integration of modern Java APIs, complex financial logic, and robust data validation, including date handling.

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.java.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

---

## 1. Overview

The Smart Expense Tracker provides users with a tool to gain financial insight by meticulously recording and analyzing their spending habits. The system's core value lies in its ability to enforce a budget and provide immediate alerts on overspending, moving beyond simple data entry to offer genuine financial intelligence.

### Core Features

*   **Expense Recording:** Structured entry of expenses with amount, category, date, and notes.
*   **Budget Monitoring:** Ability to set a monthly budget and track total spending against it.
*   **Financial Alerts:** Immediate feedback and alerts when spending exceeds the set budget.
*   **Spending Analysis:** Calculation of total spending and filtering of expenses by category.
*   **Date Handling:** Utilizes the modern `java.time.LocalDate` API for accurate and validated date entry (YYYY-MM-DD format).
*   **Robust Validation:** Comprehensive input validation for all numeric and date fields.

---

## 2. Technical Architecture

The system is built on core Java principles, leveraging the modern `java.time` package for reliable date management, a key requirement for any financial application.

### Key Technical Components

| Component | Role | Key Concepts Demonstrated |
| :--- | :--- | :--- |
| **Java** | Core programming language. | Object-Oriented Programming (OOP). |
| **`LocalDate` API** | Handles all date-related operations. | Modern API Integration, Date Validation. |
| **Collections** | `ArrayList` is used for storing and managing expense records. | Data Structure Management, Dynamic Storage. |
| **Exception Handling** | Manages errors like `InputMismatchException` and `DateTimeParseException`. | Robustness, Graceful Error Recovery. |

### Design Decisions

The design focuses on providing accurate financial reporting and a robust user experience.

*   **Modern Date API:** The use of `java.time.LocalDate` ensures that date parsing and validation are handled correctly, avoiding the pitfalls of older date libraries.
*   **Business Logic:** The budget tracking and alert system are implemented as core business logic, providing immediate, actionable feedback to the user.
*   **Category-Based Filtering:** Allows for quick and meaningful analysis of spending patterns, a feature essential for effective financial management.

### Code Example: Budget Status Logic

The system calculates the budget status by comparing total spending against the monthly limit:

```
===== BUDGET STATUS =====
Monthly Budget: 50000.00 PKR
Total Spending: 35000.00 PKR
Status: You are within the budget. Remaining: 15000.00 PKR
```

---

## 3. How to Run

### Prerequisites
*   Java Development Kit (JDK) 8 or higher

### Installation and Execution

1.  **Clone the repository** (Assuming a standard project structure).
2.  **Compile all files:**
    ```bash
    javac *.java
    ```

3.  **Run the application:**
    ```bash
    java Manager
    ```

### Sample Usage

```
Enter amount: 5000
Enter category: Food
Enter date (YYYY-MM-DD): 2025-01-15
Enter note: Groceries shopping
Expense added successfully!
```

---

## 4. Limitations and Future Enhancements

### Known Limitations

*   **Persistence:** Data is stored in memory only and is lost upon application exit.
*   **Interface:** Limited to a console-only interface.
*   **Scope:** Budget is currently monthly and not dynamic (e.g., weekly or custom periods).

### What I'd Do Next

*   Implement **database persistence** (e.g., using JDBC) or file-based storage to save expense data permanently.
*   Develop a **Graphical User Interface (GUI)** using JavaFX or Swing.
*   Add **user authentication** and multi-user support.
*   Implement **advanced reporting** features, such as monthly trend analysis and visualization.
*   Integrate **Unit Tests** to ensure the accuracy of all financial calculations and date validation logic.

---

## 5. Contact and License

### Author

**Muhammad Ahmad**

*   GitHub: [@muhammad-ahmadp](https://github.com/muhammad-ahmadp)
*   LinkedIn: [muhammad-ahmadcs](https://linkedin.com/in/muhammad-ahmadcs)

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

### Acknowledgments

This project was built to demonstrate the practical application of Java's modern date/time API and the implementation of financial business logic.
