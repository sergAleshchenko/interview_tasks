package andrei_pangin;

import java.nio.ByteBuffer;

/**
 * @author Sergei Aleshchenko
 */
public interface Field {
    double read(ByteBuffer buf, int offset);
}

class IntField implements Field {
    @Override
    public double read(ByteBuffer buf, int offset) {
        return buf.getInt(offset);
    }
}


class LongField implements Field {
    @Override
    public double read(ByteBuffer buf, int offset) {
        return buf.getLong(offset);
    }
}

class ShortField implements Field {
    @Override
    public double read(ByteBuffer buf, int offset) {
        return buf.getShort(offset);
    }
}

class FloatField implements Field {
    @Override
    public double read(ByteBuffer buf, int offset) {
        return buf.getFloat(offset);
    }
}

class DoubleField implements Field {
    @Override
    public double read(ByteBuffer buf, int offset) {
        return buf.getDouble(offset);
    }
}

