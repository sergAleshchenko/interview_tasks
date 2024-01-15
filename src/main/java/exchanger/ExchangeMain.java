package exchanger;

import java.util.concurrent.TimeUnit;

public class ExchangeMain {
    public static void main(String[] args) {
        ItemAction action = new ItemAction();

        Item tie = new Item(101, 5.0, "Tie");
        Item gloves = new Item(171, 7.0, "Gloves");

        System.out.println(tie + "" + gloves);

        new Thread(() ->
                action.doActionPrice(tie, 0.9f)).start();

        new Thread(() ->
                action.doActionDescription(gloves, " with discount")).start();


        try {
            TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(tie + "" + gloves);
    }
}
