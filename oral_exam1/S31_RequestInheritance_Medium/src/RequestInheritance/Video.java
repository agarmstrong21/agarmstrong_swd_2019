package RequestInheritance;

public class Video {
    private static String url;
    private static String title;
    private static String name;

    public Video(String url, String title, String name) {
        Video.url = url;
        Video.title = title;
        Video.name = name;
    }

    @Override
    public String toString() {
        return "\nUniversal Resource Locator (URL): " + url +
                "\nVideo: " + title +
                "\nBy: " + name;

    }
}
