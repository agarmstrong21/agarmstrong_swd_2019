package RequestInheritance;
import java.util.UUID;

public class GetRequest extends Request{
    private static int count = 0;
    private static String url;

    public GetRequest(UUID uuid, String url) {
        super(uuid);
        GetRequest.url = url;
        count++;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        GetRequest.count = count;
    }

    @Override
    public String toString() {
        return super.toString() + "\nUniversal Resource Locator (URL): " + url;
    }
}
