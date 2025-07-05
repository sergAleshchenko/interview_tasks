package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            System.out.println("Hello, MyServer!");
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket accept = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());

            while (true) {
                String result = dataInputStream.readUTF();
                System.out.println("Message = " + result);
            }
//            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
