package others;

import java.io.IOException;
import java.io.OutputStream;

public class Quest {
    int counter;
    OutputStream out;

    public Quest(OutputStream out) {
        this.out = out;
    }

    float inc() {
        try {
            counter++;
            out.write(counter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return counter;
    }
}
