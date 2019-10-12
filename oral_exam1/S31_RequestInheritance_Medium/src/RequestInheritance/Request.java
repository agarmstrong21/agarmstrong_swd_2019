/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: Request
Class Description: A superclass that takes in the UUID and stores this data for later use. Contains many subclasses
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported UUID class to store the uuid for Request
import java.util.UUID;

// Creating Request class
/**A superclass that takes in the UUID and stores this data for later use. Contains many subclasses*/
public class Request {

    // Private static variables of count and uuid to store data taken in
    private static int count = 0;
    private static UUID uuid;

    // Constructor of Request
    public Request(UUID uuid) {
        Request.uuid = uuid;
        count++;
    }

    // Getter of count
    public static int count() {
        return count;
    }

    // Getter of uuid
    public static UUID uuid() {
        return uuid;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return super.toString() + "\nUUID: " + uuid;
    }
}
