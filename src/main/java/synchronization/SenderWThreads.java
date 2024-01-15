package synchronization;

public class SenderWThreads extends Thread {
    private String msg;
    Sender sender;

    public SenderWThreads(String msg, Sender sender) {
        this.msg = msg;
        this.sender = sender;
    }

    @Override
    public void run() {
        synchronized (sender) {
            sender.senderMsg(msg);
        }
    }
}
