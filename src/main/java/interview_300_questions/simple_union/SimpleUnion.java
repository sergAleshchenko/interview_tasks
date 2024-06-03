package interview_300_questions.simple_union;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Sergei Aleshchenko
 */
public class SimpleUnion {

    private Map<String, String> keyMap;
    private Map<String, String> valueMap;

    private String domain;
    private char myChars[];
    private Random myRand;
    private int keyLength;

    public SimpleUnion() {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
        myRand = new Random();
        keyLength = 8;
        myChars = new char[62];


        for (int i = 0; i < 62; i++) {
            int j = 0;
            if (i < 10) {
                j = i + 48;
            } else if (i > 9 && i <= 35) {
                j = i + 55;
            } else {
                j = i + 61;
            }
            myChars[i] = (char) j;
        }
        domain = "http://fkt/in";
    }

    public SimpleUnion(int keyLength, String newDomain) {
        this();
        this.keyLength = keyLength;
        if (!newDomain.isEmpty()) {
            newDomain = sanitizeURL(newDomain);
            domain = newDomain;
        }
    }

    public String shortenURL(String longURL) {
        String shortURL = "";

        if (validateURL(longURL)) {
            longURL = sanitizeURL(longURL);
            if (valueMap.containsKey(longURL)) {
                shortURL = domain + "/" + valueMap.get(longURL);
            } else {
                shortURL = domain + "/" + getKey(longURL);
            }
        } else {
            shortURL = "Not valid URL";
        }
        return shortURL;
    }


    public String expandURL(String shortURL) {
        String longURL = "";
        if (validateURL(shortURL)) {
            String key = shortURL.substring(domain.length() + 1);
            longURL = keyMap.get(key);
        } else {
            longURL = "Not valid URL";
        }
        return longURL;
    }

    public boolean validateURL(String url) {
        return url.startsWith("http") || url.startsWith("www");
    }

    public String sanitizeURL(String url) {
        if (url.startsWith("http://")) {
            url = url.substring(7);
        }

        if (url.startsWith("https://")) {
            url = url.substring(8);
        }

        if (url.charAt(url.length() - 1) == '/') {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

    public String getKey(String longURL) {
        String key = generateKey();
        keyMap.put(key, longURL);
        valueMap.put(longURL, key);
        return key;
    }

    private String generateKey() {
        String key = "";
        boolean flag = true;
        while (flag) {
            key = "";
            for (int i = 0; i <= keyLength; i++) {
                key += myChars[myRand.nextInt(62)];
            }
            // System.out.println("Iteration: "+ counter + "Key: "+ key);
            if (!keyMap.containsKey(key)) {
                flag = false;
            }
        }
        return key;
    }

    public static void main(String args[]) {
        SimpleUnion u = new SimpleUnion(5, "www.tinyurl.com/");
        String urls[] = {
                "www.google.com/asasdfasdfasdfasdf/",
                "www.google.com/asasdfasdfasdfasdf/",
                "http://www.yahoo.com/asasdfasdfasdfasdf",
                "www.yahoo.com/asasdfasdfasdfasdf/",
                "www.amazon.com/asasdfasdfasdfasdf",
                "www.amazon.com/page1.php",
                "www.amazon.com/page2.php",
                "www.flipkart.in/asasdfasdfasdfasdf/",
                "www.rediff.com/asasdfasdfasdfasdf",
                "www.techmeme.com/asasdfasdfasdfasdf/",
                "www.techcrunch.com/asasdfasdfasdfasdf",
                "www.lifehacker.com/asasdfasdfasdfasdf",
                "www.icicibank.com/asasdfasdfasdfasdf/",
                "asdfasdfasdfsadf"
        };

        for (int i = 0; i < urls.length; i++) {
            System.out.println("URL:" + urls[i] + "\t\tTiny: "
                    + u.shortenURL(urls[i]) + "\t\tExpanded: "
                    + u.expandURL(u.shortenURL(urls[i])));
        }
    }
}
