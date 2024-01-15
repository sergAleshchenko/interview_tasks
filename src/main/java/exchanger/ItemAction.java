package exchanger;

import java.util.concurrent.Exchanger;

public class ItemAction {
    private static Exchanger<Item> exchanger = new Exchanger<>();

    public void doActionPrice(Item item, float discount) {
        try {
            item.setPrice(item.getPrice() * discount);
            item = exchanger.exchange(item);
            item.setPrice(item.getPrice() * discount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doActionDescription(Item item, String desc) {
        try {
            item.setDescription(item.getDescription() + desc);
            item = exchanger.exchange(item);
            item.setDescription(item.getDescription() + desc);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
