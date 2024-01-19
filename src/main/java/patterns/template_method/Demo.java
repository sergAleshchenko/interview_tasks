package patterns.template_method;

import patterns.template_method.networks.Facebook;
import patterns.template_method.networks.Network;
import patterns.template_method.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sergei Aleshchenko
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Network network = null;

        System.out.println("Input user name: ");
        String userName = reader.readLine();

        System.out.println("Input password: ");
        String password = reader.readLine();

        System.out.println("Input message");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message\n" +
                "1 - Facebook\n" +
                "2 - Twitter");

        int choice = Integer.parseInt(reader.readLine());
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else {
            network = new Twitter(userName, password);
        }

        network.post(message);
    }
}
