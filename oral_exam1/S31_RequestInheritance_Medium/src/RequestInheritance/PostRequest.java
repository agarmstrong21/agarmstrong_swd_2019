/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: PostRequest
Class Description: A subclass of Request that stores the IP address of the UUID
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported UUID for superclass
import java.util.UUID;

// Creating PostRequest class
/**A subclass of Request that stores the IP address of the UUID*/
public class PostRequest extends Request{

    // Private static variables that store data for count and ip
    private static int count = 0;
    private static String ip;

    // Constructor for PostRequest
    public PostRequest(UUID uuid, String ip) {
        super(uuid);
        PostRequest.ip = ip;
        count++;
    }

    // Getter for count
    public static int count() {
        return count;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return super.toString() + "\nPost request to server with IP address: " + ip;
    }
}
