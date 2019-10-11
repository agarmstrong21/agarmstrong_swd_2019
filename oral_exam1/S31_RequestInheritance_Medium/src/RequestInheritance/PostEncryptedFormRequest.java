package RequestInheritance;

public class PostEncryptedFormRequest {
    private int count = 0;

    public PostEncryptedFormRequest(int count) {
        this.count = count;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
