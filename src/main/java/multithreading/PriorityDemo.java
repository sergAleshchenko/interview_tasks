package multithreading;

public class PriorityDemo {
    public static void main(String[] args) {
        WalkThread walkThread = new WalkThread();
        Thread talk = new Thread(new TalkThread());

        talk.setPriority(Thread.MIN_PRIORITY);
        walkThread.setPriority(Thread.MAX_PRIORITY);

        talk.start();
        walkThread.start();
    }
}
