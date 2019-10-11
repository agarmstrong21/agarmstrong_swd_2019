package RequestInheritance;

public class PostEncryptedPaymentRequest {
    private static int count = 0;

    public PostEncryptedPaymentRequest(int count) {
        this.count = count;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
