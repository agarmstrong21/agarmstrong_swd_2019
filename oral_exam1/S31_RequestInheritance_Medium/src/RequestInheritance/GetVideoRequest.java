package RequestInheritance;

public class GetVideoRequest {
    private static int count = 0;

    public GetVideoRequest(int count) {
        this.count = count;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
