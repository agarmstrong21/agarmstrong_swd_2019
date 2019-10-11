package RequestInheritance;

public class PostFormRequest {
    private static int count = 0;

    public PostFormRequest(int count) {
        this.count = count;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
