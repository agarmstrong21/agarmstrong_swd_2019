/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: GetFileRequest
Class Description: A class that is a subclass of GetRequest. This class contains a file from File class.
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Imported classes used for the superclass
import java.util.UUID;

// Creating of the GetFileRequest class
/** A class that is a subclass of GetRequest. This class contains a file from File class.*/
public class GetFileRequest extends GetRequest{

    // Two private static variables that
    private static int count = 0;
    private static File file;

    // Constructor of GetFileRequest
    public GetFileRequest(UUID uuid, File file) {
        super(uuid, "file://" + File.filepath() + "." + File.filetype());
        GetFileRequest.file = file;
        count++;
    }

    // Getter for count
    public static int count() {
        return count;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return super.toString() + file.toString() ;
    }
}
