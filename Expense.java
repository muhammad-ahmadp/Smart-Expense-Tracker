import java.time.LocalDate;

public class Expense {
    private double amount;
    private String category;
    private LocalDate date;
    private String note;

    public Expense(double amount, String category, LocalDate date, String note) {
        if (amount < 0 || category == null || category.trim().isEmpty()
                || date == null || note == null || note.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Invalid input: Amount must be non-negative, and Category, Date, and Note cannot be empty.");
        }
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.note = note;
    }

    // Setters
    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("❌ Amount must be greater than zero!");
        }
        this.amount = amount;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Category cannot be null or empty!");
        }
        this.category = category;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("❌ Date cannot be null!");
        }
        this.date = date;
    }

    public void setNote(String note) {
        if (note == null || note.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Note cannot be null or empty!");
        }
        this.note = note;
    }

    // Getters
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }
    public String getNote() { return note; }

    @Override
    public String toString() {
        return String.format("Amount: %.2f | Category: %s | Date: %s | Note: %s",
                amount, category, date, note);
    }
}
