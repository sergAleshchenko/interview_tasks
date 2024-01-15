package multithreading;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CommonResource implements AutoCloseable {
    private FileWriter fileWriter;

    public CommonResource(String file) throws IOException {
        fileWriter = new FileWriter(file, true);
    }

    public synchronized void writing(String info, int i) {
        try {
            fileWriter.append(info + i);
            System.out.print(info + i);
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
            fileWriter.append(" -> " + info.charAt(0) + i + " \n");
            System.out.print("->" + info.charAt(0) + i + " \n");
        } catch (IOException | InterruptedException e) {
            System.err.print(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}
