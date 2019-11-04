/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: PostFormRequest
Class Description: A subclass of PostRequest that stores count and Form data
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported UUID for superclass
import java.util.UUID;

// Creating PostformRequest class
/** A subclass of PostRequest that stores count and Form data*/
public class PostFormRequest extends PostRequest{
    private static int count = 0;
    private static Form form;

    // Constructor of PostFormRequest
    public PostFormRequest(UUID uuid, String ip, Form form) {
        super(uuid, ip);
        PostFormRequest.form = form;
        count++;
    }

    // Getter of Count
    public static int count() {
        return count;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return super.toString()  +form.toString();
    }
}
