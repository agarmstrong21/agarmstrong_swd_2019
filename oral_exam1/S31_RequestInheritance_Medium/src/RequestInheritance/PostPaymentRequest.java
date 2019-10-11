package RequestInheritance;

public class PostPaymentRequest {
    private static int count = 0;

    public PostPaymentRequest(int count) {
        this.count = count;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
