public class Member {
    private PaymentList payments;
    private boolean paid;
    private Person person;
    private int maxNoOfPayments;

    public Member(String name, String address, String phone, int maxNoOfPayments) {
        this.person = new Person(name, address, phone);
        this.payments = new PaymentList(maxNoOfPayments);
        this.paid = false;
        this.maxNoOfPayments = maxNoOfPayments;
    }

    public boolean makePayment(Payment payment) {
        if (paid || payments.isFull()) {
            return false;
        }
        payments.add(payment);
        if (payments.getTotal() == maxNoOfPayments) {
            paid = true;
        }
        return true;
    }

    public PaymentList getPayments() {
        return payments;
    }

    public int getMaxNoOfPayments() {
        return maxNoOfPayments;
    }
    
    public Person getPerson() {
        return person;
    }

    public String toString() {
        return person.toString() + ", Paid: " + paid;
    }

    public void print() {
        System.out.println(toString());
    }
}
