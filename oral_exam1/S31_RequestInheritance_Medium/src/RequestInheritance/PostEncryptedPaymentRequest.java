package RequestInheritance;

import java.util.UUID;

public class PostEncryptedPaymentRequest extends PostPaymentRequest {
    private static int count = 0;
    private static String encryptionscheme;

    public PostEncryptedPaymentRequest(UUID uuid, String ip, Payment payment, String encryptionscheme) {
        super(uuid, ip, payment);
        PostEncryptedPaymentRequest.encryptionscheme = encryptionscheme;
        count++;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        PostEncryptedPaymentRequest.count = count;
    }

    @Override
    public String toString() {
        return super.toString() + "\nThis payment was encrypted using: " + encryptionscheme;
    }
}
