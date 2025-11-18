public class Budget {

    private double monthlyBudget;

    public Budget(double monthlyBudget) {
        if (monthlyBudget < 0){
            throw new IllegalArgumentException("Monthly budget cannot be negative!");
        }
        this.monthlyBudget = monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        if (monthlyBudget < 0) {
            throw new IllegalArgumentException("❌ Monthly budget cannot be negative!");
        }
        this.monthlyBudget = monthlyBudget;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    @Override
    public String toString() {
        return String.format("Monthly Budget: %.2f", monthlyBudget);
    }
}
