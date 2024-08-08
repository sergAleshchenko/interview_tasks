package tdd;

import fx_pro.EmptyBufferException;
import fx_pro.FullBufferException;
import fx_pro.RingBuffer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sergei Aleshchenko
 */
public class RingBufferTest {


    @Test
    public void getElementFormEmptyBuffer () {
        RingBuffer ringBuffer = new RingBuffer(4);

        Assert.assertThrows(EmptyBufferException.class, () -> ringBuffer.get());
    }


    @Test
    public void putElementInFullBuffer () {
        RingBuffer ringBuffer = new RingBuffer(4);
        ringBuffer.put(1);
        ringBuffer.put(2);
        ringBuffer.put(3);
        ringBuffer.put(4);

        Assert.assertThrows(FullBufferException.class, () -> ringBuffer.put(5));
    }

    @Test
    public void putElementToEmptyBuffer() {
        RingBuffer ringBuffer = new RingBuffer(4);
        ringBuffer.put(1);

        Assert.assertEquals(1, ringBuffer.get());
    }

    @Test
    public void putElementToNotEmptyBuffer() {
        RingBuffer ringBuffer = new RingBuffer(4);
        ringBuffer.put(1);
        ringBuffer.put(2);


        Assert.assertEquals(1, ringBuffer.get());
        Assert.assertEquals(2, ringBuffer.get());

    }

}
