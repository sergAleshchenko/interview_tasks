package synchronization;

public class SynchronizedMain {
    public static void main(String[] args) {
        Sender sender = new Sender();
        SenderWThreads sender1 = new SenderWThreads("Hello", sender);
        SenderWThreads sender2 = new SenderWThreads("Welcome to JavaTPoint website", sender);

        sender1.start();
        sender2.start();

        try {
            sender1.join();
            sender2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
