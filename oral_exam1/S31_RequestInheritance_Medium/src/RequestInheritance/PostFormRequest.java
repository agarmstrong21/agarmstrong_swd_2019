package RequestInheritance;

import java.util.UUID;

public class PostFormRequest extends PostRequest{
    private static int count = 0;
    private static Form form;

    public PostFormRequest(UUID uuid, String ip, Form form) {
        super(uuid, ip);
        PostFormRequest.form = form;
        count++;
    }

    public static int count() {
        return count;
    }

    @Override
    public String toString() {
        return super.toString()  +form.toString();
    }
}
