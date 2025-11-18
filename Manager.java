import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();
        boolean exit = false;


        while (!exit){
            System.out.println("\n===== SMART EXPENSE TRACKER =====");
            System.out.println("1. Add New Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Spending");
            System.out.println("4. View Expenses by Category");
            System.out.println("5. Set Monthly Budget");
            System.out.println("6. Check Budget Status");
            System.out.println("7. Save & Exit");
            System.out.print("Enter your choice: ");

            int choice;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
            } else {
                System.out.println("❌ Invalid choice! Enter a number from 1 to 7.");
                sc.nextLine(); // Consume invalid input
                continue;
            }
            switch (choice){
                case 1 -> {
                    double amount = -1;
                    String category, note;
                    LocalDate date;

                    try {
                        System.out.print("Enter amount: ");
                        amount = sc.nextDouble();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid amount format. Please enter a number.");
                        sc.nextLine();
                        break;
                    }

                    System.out.print("Enter category (Food, Travel, Bills, Shopping, Other): ");
                    category = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String newDate = sc.nextLine();

                    try {
                        date = LocalDate.parse(newDate);
                    } catch (DateTimeParseException ex) {
                        System.out.println("❌ Invalid date format. Use YYYY-MM-DD.");
                        break;
                    }

                    System.out.print("Enter note: ");
                    note = sc.nextLine();

                    try {
                        Expense expense = new Expense(amount, category, date, note);
                        expenseManager.addExpense(expense);
                        System.out.println("✅ Expense added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    expenseManager.viewAllExpenses();
                }
                case 3 -> {
                    expenseManager.viewTotalSpending();
                }
                case 4 -> {
                    System.out.print("Enter category to filter: ");
                    String category = sc.nextLine();
                    expenseManager.filterExpenses(category);
                }
                case 5 -> {
                    double budgetAmount = -1;
                    try {
                        System.out.print("Enter monthly budget: ");
                        budgetAmount = sc.nextDouble();
                        sc.nextLine();

                        Budget budget1 = new Budget(budgetAmount);
                        expenseManager.setBudget(budget1);
                        System.out.println("✅ Monthly budget set successfully!");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid budget format. Please enter a number.");
                        sc.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    expenseManager.viewBudget();
                }
                case 7 -> {
                    exit = true;
                    System.out.println("Saving data... (Note: Data is only stored in memory)");
                    System.out.println("Exiting system...");
                }
                default -> System.out.println("❌ Invalid choice! Enter 1-7.");
            }
        }
        sc.close();
    }
}