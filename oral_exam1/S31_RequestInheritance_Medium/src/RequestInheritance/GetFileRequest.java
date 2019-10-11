package RequestInheritance;

import java.util.UUID;

public class GetFileRequest extends GetRequest{
    private static int count = 0;
    private static File file;

    public GetFileRequest(UUID uuid, File file) {
        super(uuid, "file://" + File.filepath() + "." + File.filetype());
        GetFileRequest.file = file;
        count++;
    }

    public static int count() {
        return count;
    }

    public void setCount(int count) {
        GetFileRequest.count = count;
    }

    @Override
    public String toString() {
        return super.toString() + file.toString() ;
    }
}
