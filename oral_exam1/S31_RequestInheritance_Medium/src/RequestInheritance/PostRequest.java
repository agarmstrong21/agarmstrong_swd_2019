package RequestInheritance;

import java.util.UUID;

public class PostRequest extends Request{
    private static int count = 0;
    private static String ip;

    public PostRequest(UUID uuid, String ip) {
        super(uuid);
        PostRequest.ip = ip;
        count++;
    }

    public static int count() {
        return count;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPost request to server with IP address: " + ip;
    }
}
