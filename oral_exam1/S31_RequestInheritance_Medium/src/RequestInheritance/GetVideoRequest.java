/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: GetVideoRequest
Class Description: A class that gets the Video and uses the superclass Request for data storing.
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Importing UUID for the superclass
import java.util.UUID;

// Creating the GetVideoRequest Class
/** A class that gets the Video and uses the superclass Request for data storing.*/
public class GetVideoRequest extends Request{

    // Private static variables of count and video. These store data of the amount of uses this class as encountered
        //and the video file.
    private static int count = 0;
    private static Video video;

    // Constructor of GetVideoRequest
    public GetVideoRequest(UUID uuid, Video video) {
        super(uuid);
        GetVideoRequest.video = video;
        count++;
    }

    // Getter of count
    public static int count() {
        return count;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return super.toString() + video.toString();
    }
}
