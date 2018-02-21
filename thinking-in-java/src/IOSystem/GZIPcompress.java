package IOSystem;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("notes.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Write file process");
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();
        System.out.println("Reading file process");
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz")))
        );
        String s;
        while ((s = in2.readLine()) != null)
            System.out.println(s);
    }
}
