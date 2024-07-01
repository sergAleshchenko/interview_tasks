package cryptographics;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Sergei Aleshchenko
 */
public class Solution {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {


        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

    }
}
