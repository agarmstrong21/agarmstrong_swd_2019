package RequestInheritance;

import java.util.UUID;

public class GetFileRequest {
    private static int count = 0;
    private static UUID uuid;

    public GetFileRequest(UUID uuid) {
        GetFileRequest.uuid = uuid;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
