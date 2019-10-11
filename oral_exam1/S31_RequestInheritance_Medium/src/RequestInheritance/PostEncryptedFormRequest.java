package RequestInheritance;

import java.util.UUID;

public class PostEncryptedFormRequest extends PostFormRequest{
    private static int count = 0;
    private static String encryptionscheme;

    public PostEncryptedFormRequest(UUID uuid, String ip, Form form, String encryptionscheme) {
        super(uuid, ip, form);
        PostEncryptedFormRequest.encryptionscheme = encryptionscheme;
        count++;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        PostEncryptedFormRequest.count = count;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nThis form was encrypted using: " + encryptionscheme;
    }
}
