/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: PostEncryptedFormRequest
Class Description: A subclass of PostFormRequest that stores the count and encryption scheme.
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported UUID used for superclass
import java.util.UUID;

// Creating of PostEncryptedFormRequest Class
/** A subclass of PostFormRequest that stores the count and encryption scheme.*/
public class PostEncryptedFormRequest extends PostFormRequest{

    // Private static variables that store data about count and the encryptionscheme
    private static int count = 0;
    private static String encryptionscheme;

    // Construction of PostEncryptionFormRequest
    public PostEncryptedFormRequest(UUID uuid, String ip, Form form, String encryptionscheme) {
        super(uuid, ip, form);
        PostEncryptedFormRequest.encryptionscheme = encryptionscheme;
        count++;
    }

    // Getter of count
    public static int count() {
        return count;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return super.toString() +
                "\nThis form was encrypted using: " + encryptionscheme;
    }
}
