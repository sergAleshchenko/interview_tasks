package algorithms;

import java.util.Scanner;

/**
 * @author Sergei Aleshchenko
 */
public class Anagrams {

    static boolean isAnagram(String a, String b) {

        byte[] aBytes = a.toLowerCase().getBytes();
        byte[] bBytes = b.toLowerCase().getBytes();

        if(aBytes.length != bBytes.length) return false;

        for (int j = 0; j < aBytes.length; j++) {
            for (int k = j; k < aBytes.length; k++) {
                if(aBytes[k] <= aBytes[j]) {
                    byte temp = aBytes[j];
                    aBytes[j] = aBytes[k];
                    aBytes[k] = temp;
                }

                if(bBytes[k] <= bBytes[j]) {
                    byte temp = bBytes[j];
                    bBytes[j] = bBytes[k];
                    bBytes[k] = temp;
                }
            }
        }
        System.out.println("aBytes after sorting: ");

        for (byte aByte : aBytes) {
            System.out.print(aByte + " ");
        }

        System.out.println();

        System.out.println("bBytes after sorting: ");
        for (byte bByte : bBytes) {
            System.out.print(bByte + " ");
        }


        for (int i = 0; i < aBytes.length; i++) {
            if(aBytes[i] == bBytes[i]) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
