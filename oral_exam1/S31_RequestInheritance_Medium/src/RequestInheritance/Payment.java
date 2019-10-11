package RequestInheritance;

public class Payment {
    private static String sender;
    private static int charge;
    private static String receiver;

    public Payment(String sender, int charge, String receiver) {
        Payment.sender = sender;
        Payment.charge = charge;
        Payment.receiver = receiver;
    }

    @Override
    public String toString() {
        return "\nPayment Data" +
                "\nPayment sender: " + sender +
                "\nPayment amount: $" + charge +
                "\nPayment receiver: " + receiver;
    }
}
