package andrei_pangin;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author Sergei Aleshchenko
 */
public class Fields {

    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocateDirect(100);
        buf.order(ByteOrder.nativeOrder());

        Field[] fields = {
                new IntField(),
                new LongField(),
                new ShortField(),
                new FloatField(),
                new DoubleField()
        };

        while (true) {
            read(buf, fields);
        }
    }

    public static void read(ByteBuffer buf, Field[] fields) {
        for (Field f : fields) {
            f.read(buf, 0);
        }
    }
}
