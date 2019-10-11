package RequestInheritance;

import java.util.UUID;

public class PostPaymentRequest extends PostRequest{
    private static int count = 0;
    private static Payment payment;

    public PostPaymentRequest(UUID uuid, String ip, Payment payment) {
        super(uuid, ip);
        PostPaymentRequest.payment = payment;
        count++;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        PostPaymentRequest.count = count;
    }

    public static Payment payment(){
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + payment.toString();
    }
}
