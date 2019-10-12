/*
Name: Addison Armstrong
Name of Project: S31_RequestInheritance_Medium
Name of Class: File
Class Description: A class where file data is stored. The file path where the file is located is stored
along with the file type.
 */

// Adding this file into the package of RequestInheritance and accessing any files inside of this package
package RequestInheritance;

// Creating the File Class
/** A class where file data is stored. The file path where the file is located is stored
 along with the file type. */
public class File {

    // File class contains two private static variables, filepath and filetype
    private static String filepath;
    private static String filetype;

    // File constructor
    public File(String filepath, String filetype){
        File.filepath = filepath;
        File.filetype = filetype;
    }

    // filepath getter
    static String filepath(){
        return filepath;
    }

    // filetype getter
    static String filetype() {
        return filetype;
    }

    // Overrided toString method for File
    @Override
    public String toString() {
        return "\nFile Path: " + filepath +
                "\nFile Type: " + filetype;

    }
}
