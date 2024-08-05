package comteck;

import java.util.Scanner;

/**
 * @author Sergei Aleshchenko
 */ 
public class IsTheWordPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        String reversedString = new StringBuilder(word).reverse().toString();

        System.out.println(reversedString.equals(word));


    }
}
