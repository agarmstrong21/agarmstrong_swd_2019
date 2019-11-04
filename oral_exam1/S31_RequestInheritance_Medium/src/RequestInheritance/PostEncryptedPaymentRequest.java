/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: PostEncryptedPaymentRequest
Class Description: A subclass of PostPaymentRequest that stores the encryptionscheme and count data
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported UUID for superclass
import java.util.UUID;

// Creating PostEncryptedPaymentRequest class
/**A subclass of PostPaymentRequest that stores the encryptionscheme and count data*/
public class PostEncryptedPaymentRequest extends PostPaymentRequest {

    // private static variables that stores the count and encryptionscheme
    private static int count = 0;
    private static String encryptionscheme;

    // Constructor of PostEncryptedPaymentRequest
    public PostEncryptedPaymentRequest(UUID uuid, String ip, Payment payment, String encryptionscheme) {
        super(uuid, ip, payment);
        PostEncryptedPaymentRequest.encryptionscheme = encryptionscheme;
        count++;
    }

    // Getter of count
    public static int count() {
        return count;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return super.toString() + "\nThis payment was encrypted using: " + encryptionscheme;
    }
}
