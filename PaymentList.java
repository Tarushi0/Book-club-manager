public class PaymentList extends ObjectList {
    public PaymentList(int size) {
        super(size);
    }

    public Payment getPayment(int index) {
        return (Payment) getObject(index);
    }

    public double calculateTotalPaid() {
        double totalPaid = 0;
        for (int i = 0; i < getTotal(); i++) {
            totalPaid += getPayment(i).getAmount();
        }
        return totalPaid;
    }
}
