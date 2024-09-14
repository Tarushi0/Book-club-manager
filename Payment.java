public class Payment {
    private String month;
    private double amount;

    public Payment(String month, double amount) {
        this.month = month;
        this.amount = amount;
    }

    public Payment(double amount) {
        this.month = "Full Payment";
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "Month: " + month + ", Amount: " + amount;
    }

    public void print() {
        System.out.println(toString());
    }
}
