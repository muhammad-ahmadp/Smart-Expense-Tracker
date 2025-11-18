import java.util.ArrayList;

public class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>();
    private Budget budget;

    public void addExpense (Expense expense){
        expenses.add(expense);
    }

    public void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("❌ No expenses found!");
            return;
        }

        System.out.println("===== ALL EXPENSES =====");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
        System.out.println("----------------------------------");
    }

    // FIX: Filter logic now iterates through all expenses, prints matches, and calculates the category total.
    public void filterExpenses(String category){
        ArrayList<Expense> filtered = new ArrayList<>();
        double categoryTotal = 0.0;

        // Find all expenses in the category
        for (Expense expense : expenses){
            if (expense.getCategory().equalsIgnoreCase(category.trim())){
                filtered.add(expense);
                categoryTotal += expense.getAmount();
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("❌ No expenses found for category: " + category);
            return;
        }

        System.out.println(String.format("===== EXPENSES FOR CATEGORY: %s =====", category.toUpperCase()));
        for (Expense expense : filtered) {
            System.out.println(expense.toString());
        }
        System.out.println("---------------------------------------");
        System.out.println(String.format("Total Spending in %s: %.2f PKR", category.toUpperCase(), categoryTotal));
    }


    public double calculateTotal (){
        double total = 0;
        for (Expense expense : expenses){
            total += expense.getAmount();
        }
        return total;
    }

    public void viewTotalSpending (){
        System.out.println("===== TOTAL SPENDING =====");
        System.out.println("Total Spent: " + calculateTotal() + " PKR");
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Budget getBudget() {
        return budget;
    }

    public void viewBudget (){
        if (budget == null) {
            System.out.println("❌ Monthly budget has not been set yet.");
            return;
        }

        double total = calculateTotal();
        double monthlyBudget = budget.getMonthlyBudget();
        double remainingOrOver = monthlyBudget - total;

        System.out.println("===== BUDGET STATUS =====");
        System.out.println(String.format("Monthly Budget: %.2f PKR", monthlyBudget));
        System.out.println(String.format("Total Spending: %.2f PKR", total));

        if (total > monthlyBudget){
            System.out.println(String.format("Status: ❌ Budget Exceeded by %.2f PKR!", Math.abs(remainingOrOver)));
        } else {
            System.out.println(String.format("Status: ✅ You are within the budget. Remaining: %.2f PKR", remainingOrOver));
        }
    }
}