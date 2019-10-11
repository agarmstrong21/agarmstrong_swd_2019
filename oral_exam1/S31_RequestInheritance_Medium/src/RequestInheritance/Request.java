package RequestInheritance;

import java.util.UUID;

public class Request {
    private static int count = 0;
    private static UUID uuid;

    public Request(UUID uuid) {
        Request.uuid = uuid;
    }

    public static int  count() {
        return count;
    }

    public void setCount(int count) {
        Request.count = count;
    }

    public static UUID getUuid() {
        return uuid;
    }

    public static void setUuid(UUID uuid) {
        Request.uuid = uuid;
    }
}
