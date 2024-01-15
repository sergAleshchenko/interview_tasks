package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("195.201.10.8");
            System.out.println("Host name: " + inetAddress.getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
