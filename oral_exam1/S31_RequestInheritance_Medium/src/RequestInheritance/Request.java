package RequestInheritance;

import java.util.UUID;

public class Request {
    private static int count = 0;
    private static UUID uuid;

    public Request(UUID uuid) {
        Request.uuid = uuid;
        count++;
    }

    public static int count() {
        return count;
    }

    public static UUID uuid(){return uuid;}

    @Override
    public String toString() {
        return super.toString() + "\nUUID: " + uuid;
    }
}
