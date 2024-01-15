package in_out;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

public class FileMain {
    public static void main(String[] args) {
        File file = new File("data" + File.separator + "info.txt");

        if (file.exists() && file.isFile()) {
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length());
            System.out.println("Dir: " + file.getParent());
            file.delete();

            try{
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            File dir = new File("data");

            if (dir.exists() && dir.isDirectory()) {

                for (File current : dir.listFiles()) {
                    long millis = current.lastModified();
                    LocalDateTime date = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();
                    System.out.println(current.getPath() + "\t\t" + current.length() + "\t\t" + date);
                }
            }

            File root = File.listRoots()[1];
            File[] roots = File.listRoots();
            System.out.println(Arrays.toString(roots));

            System.out.printf(
                    "%s %,d GB is free from %,d GB",
                    root.getPath(),
                    root.getUsableSpace() / (1024 * 1024),
                    root.getTotalSpace() / (1024 * 1024));

        }
    }
}
