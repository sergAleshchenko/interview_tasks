package synchronization;

public class Sender {
    public void senderMsg(String msg) {
        System.out.println("Sending a message: " + msg);

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("\"" + msg + "\"" + " - sent");
    }
}
