package in_out;

import java.io.IOException;
import java.util.Scanner;

public class Quest3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int x1 = 0;
        x1 = scanner.nextInt();
//        scanner.close();

        int x2 = 0;
        x2 = System.in.read();

        System.out.println(x1 + " " + (char) x2);
    }
}
