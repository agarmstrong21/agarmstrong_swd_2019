/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: GetFileRequest
Class Description: A class that is a subclass of Request. This class takes in the URL and stores it accordingly.
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported UUID class to use for superclass
import java.util.UUID;

// Creating GetRequest Class
/** A class that is a subclass of Request. This class takes in the URL and stores it accordingly.*/
public class GetRequest extends Request{

    // private static variables count and url to store the count of how many there are of this class and the URL.
    private static int count = 0;
    private static String url;

    // Constuctor of GetRequest
    public GetRequest(UUID uuid, String url) {
        super(uuid);
        GetRequest.url = url;
        count++;
    }

    // Getter of count
    public static int count() {
        return count;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return super.toString() + "\nUniversal Resource Locator (URL): " + url;
    }
}
