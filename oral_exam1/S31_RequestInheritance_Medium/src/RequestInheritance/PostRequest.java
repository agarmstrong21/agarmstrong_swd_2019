package RequestInheritance;

import java.util.UUID;

public class PostRequest extends Request{
    private static int count = 0;
    private static UUID uuid;
    private static String ip;

    public PostRequest(UUID uuid, String ip) {
        super(uuid);
        PostRequest.uuid = uuid;
        PostRequest.ip = ip;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
