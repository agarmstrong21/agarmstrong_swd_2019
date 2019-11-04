/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: Video
Class Description: A class that stores data about the taken in Video. Stores title, url, and name of video.
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Creating Video class
/** A class that stores data about the taken in Video. Stores title, url, and name of video. */
public class Video {

    // Private static variables that stores the url, title, and author(name) of the video
    private static String url;
    private static String title;
    private static String name;

    // Constructor Video
    public Video(String url, String title, String name) {
        Video.url = url;
        Video.title = title;
        Video.name = name;
    }

    // Overrided toString method
    @Override
    public String toString() {
        return "\nUniversal Resource Locator (URL): " + url +
                "\nVideo: " + title +
                "\nBy: " + name;

    }
}
