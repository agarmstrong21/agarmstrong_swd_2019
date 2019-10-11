package RequestInheritance;

public class File {
    private static String filepath;
    private static String filetype;

    public File(String filepath, String filetype){
        File.filepath = filepath;
        File.filetype = filetype;
    }

    static String filepath(){
        return filepath;
    }

    static String filetype() {
        return filetype;
    }

    @Override
    public String toString() {
        return "\nFile Path: " + filepath +
                "\nFile Type: " + filetype;

    }
}
