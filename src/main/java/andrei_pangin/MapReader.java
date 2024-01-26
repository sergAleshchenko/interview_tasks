package andrei_pangin;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Sergei Aleshchenko
 */
public class MapReader {

    public static void main(String[] args) throws Exception {

//        fillFile();

        while (true) {
            long start = System.nanoTime();
            Map<String, Long> map = readMap("H:\\IDEA_PROJECTS\\Learning\\src\\main\\java\\andrei_pangin\\in.txt");
            long time = System.nanoTime() - start;
            System.out.printf("Read %d elements in %.3f seconds\n", map.size(), time / 1e9);
        }
    }

    private static Map<String, Long> readMap(String fileName) throws Exception {
        Map<String, Long> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for (String line; (line = br.readLine()) != null;) {
//                int sep = line.indexOf(':');
//                String key = trim(line, 0, sep);
//                String value = trim(line, sep + 1, line.length());


                int sep = line.indexOf(':');
                String key = line.substring(0, sep).trim();
                String value = line.substring(sep + 1).trim();


//                String[] kv = line.split(":", 2);
//                String key = kv[0].trim();
//                String value = kv[1].trim();

                map.put(key, Long.parseLong(value));
            }
        }

        return map;
    }

    private static void fillFile() {
        HashMap<String, Long> map = new HashMap<>();

        for (long i = 0; i < 1000000; i++) {
            map.put("Key" + i, i);
        }

        File file = new File("H:\\IDEA_PROJECTS\\Learning\\src\\main\\java\\andrei_pangin\\in.txt");
        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }


    private static String trim(String line, int from, int to) {
        while (from < to && line.charAt(from) <= ' ') {
            from++;
        }

        while (to > from && line.charAt(to - 1) <= ' ') {
            to--;
        }

        return line.substring(from, to);
    }
}
