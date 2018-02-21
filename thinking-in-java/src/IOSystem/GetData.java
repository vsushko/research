package IOSystem;

import java.nio.ByteBuffer;

public class GetData {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0) {
                System.out.println("nonzero");
                System.out.print("i = " + i);
            }
        bb.rewind();
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0) {
            System.out.print(c + "");
        }
        bb.rewind();
        bb.asShortBuffer().put((short) 471142);
        System.out.println(bb.getShort());
        bb.rewind();

        bb.asIntBuffer().put((short) 3124137);
        System.out.println(bb.getInt());
        bb.rewind();
    }
}
