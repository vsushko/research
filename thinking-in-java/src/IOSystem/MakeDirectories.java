package IOSystem;

import java.io.File;

public class MakeDirectories {
    private static void usage() {
        System.err.println(
                "Usage: MakeDirectories path1 ...\n" +
                "Create all paths\n" +
                "Using: MakeDirectories -d path1 ...\n" +
                "Remove all paths\n" +
                "Using: MakeDirectories -r path1 в path2\n" +
                "Rename path1 в path2\n"
        );
        System.exit(1);
    }
    private static void fileData(File f) {
        System.out.println("Full name: " + f.getAbsolutePath() +
        "\nEnable for read: " +  f.canRead() +
        "\nEnable for write: " + f.canWrite() +
        "\nFile name: " + f.getName() +
        "\nBase catalog: " + f.getParent() +
        "\nPath: " + f.getPath() +
        "\nSize: " + f.length() +
        "\nLast modified: " + f.lastModified());

        if (f.isFile()) {
            System.out.println("This is file");
        }
        else if (f.isDirectory())
            System.out.println("This is catalog");
    }
    public static void main(String[] args) {
        if (args.length < 1)
            usage();
        if (args[0].equals("-r")) {
            if (args.length != 3)
                usage();
            File old = new File(args[1]),
                 rname = new File(args[2]);
            old.renameTo(rname);
            fileData(old);
            fileData(rname);
            return;
        }
        int count = 0;
        boolean del = false;
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File f = new File(args[count]);
            if (f.exists()) {
                System.out.println(f + "Excist!");
                if (del) {
                    System.out.println("removing..." + f);
                    f.delete();
                }
            }
            else { // not excist
                if (!del) {
                    f.mkdir();
                    System.out.println("Created " + f);
                }
            }
            fileData(f);
        }
    }
}