/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: PostPaymentRequest
Class Description: A subclass of PostRequest that stores data for count and Payment.
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported UUID for superclass
import java.util.UUID;

// Creating PostPaymentRequest class
/**A subclass of PostRequest that stores data for count and Payment.*/
public class PostPaymentRequest extends PostRequest{

    // Private static variables for count and payment
    private static int count = 0;
    private static Payment payment;

    // Constructor for PostPaymentRequest
    public PostPaymentRequest(UUID uuid, String ip, Payment payment) {
        super(uuid, ip);
        PostPaymentRequest.payment = payment;
        count++;
    }

    // Getter for count
    public static int count() {
        return count;
    }

    //Overrided toString method
    @Override
    public String toString() {
        return super.toString() + payment.toString();
    }
}
