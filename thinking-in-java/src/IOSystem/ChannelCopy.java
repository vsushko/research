package IOSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException {
       FileChannel in = new FileInputStream("data.txt").getChannel(),
                out = new FileOutputStream("test.txt").getChannel();
       ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
       while (in.read(buffer) != -1) {
           buffer.flip();
           out.write(buffer);
           buffer.clear();
       }
    }
}
class TransferTo {
    public static void main(String[] args) throws IOException {
        FileChannel in = new FileInputStream("data.txt").getChannel(),
                out = new FileOutputStream("test.txt").getChannel();
        in.transferTo(0, in.size(), out);

    }
}
