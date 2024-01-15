package enum_wrong_examples;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;

public enum Pool {
    INSTANCE;
    private BlockingQueue<Plane> planes;
    Pool() {
    }
}
