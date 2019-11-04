/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: Payment
Class Description: A class that store payment information like sender, charges, and receiver.
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Creating Payment Class
/** A class that store payment information like sender, charges, and receiver.*/
public class Payment {

    // Private static variables that contains data of a payment process
    private static String sender;
    private static int charge;
    private static String receiver;

    // Constructor of Payment class
    public Payment(String sender, int charge, String receiver) {
        Payment.sender = sender;
        Payment.charge = charge;
        Payment.receiver = receiver;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return "\nPayment Data" +
                "\nPayment sender: " + sender +
                "\nPayment amount: $" + charge +
                "\nPayment receiver: " + receiver;
    }
}
