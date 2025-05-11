package others;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class ShaDemo {
    public static void main(String[] args) {

        String unencrypted = "v";
        byte[] bytes = null;



//        Base64.Encoder encoder = Base64.getEncoder();
//        bytes = encoder.encode(unencrypted.getBytes());

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(unencrypted.getBytes("utf-8"));
            bytes = messageDigest.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(bytes.toString());
        BigInteger bigInteger = new BigInteger(1, bytes);

        String encrypted = bigInteger.toString(16);
        System.out.println(encrypted);

    }
}
