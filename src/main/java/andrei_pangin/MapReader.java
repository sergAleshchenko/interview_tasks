package andrei_pangin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
public class MapReader {

    public static void main(String[] args) {

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
