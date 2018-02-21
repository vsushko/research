package IOSystem;

import java.io.*;

public class FormattedMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(BufferedInputFile.read("notes.txt").getBytes())
            );
            while (true)
                System.out.print((char)in.readByte());
        } catch (IOException e) {
            System.err.println("End of stream");
        }
    }
}
class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("notes.txt"))
        );
        while (in.available() != 0)
            System.out.print((char)in.readByte());
    }

}
