package multithreading;

public class DaemonDemo {
    public static void main(String[] args) {
        WalkThread walk = new WalkThread();
        Thread talk = new Thread(new TalkThread());
        talk.setDaemon(true);

        talk.start();
        walk.start();
        System.out.println("End of Main");
    }
}
