package RequestInheritance;

import java.util.UUID;

public class GetVideoRequest extends Request{
    private static int count = 0;
    private static Video video;

    public GetVideoRequest(UUID uuid, Video video) {
        super(uuid);
        GetVideoRequest.video = video;
        count++;
    }

    public static int count() {
        return count;
    }

    public  void setCount(int count) {
        GetVideoRequest.count = count;
    }

    @Override
    public String toString() {
        return super.toString() + video.toString();
    }
}
