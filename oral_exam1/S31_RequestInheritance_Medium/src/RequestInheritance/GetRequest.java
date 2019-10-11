package RequestInheritance;
import java.util.UUID;

public class GetRequest extends Request{
    private static int count = 0;
    private static UUID uuid;
    private static String url;

    public GetRequest(UUID uuid, String url) {
        super(uuid);
        GetRequest.uuid = uuid;
        GetRequest.url = url;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
