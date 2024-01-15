package others;

import java.io.Console;
import java.io.IOException;

public class ReadFromConsoleDemo {
    public static void main(String[] args) throws IOException {
        Console c=System.console();
        System.out.println("Enter your name: ");
        String n=c.readLine();
        System.out.println("Welcome "+n);
    }
}

