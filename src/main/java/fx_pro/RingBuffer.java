package fx_pro;

/**
 * @author Sergei Aleshchenko
 */

/**
 * 1. FIFO
 * 2. Ring buffer, use all space in the buffer. Throw exception in corner cases:  no free space (on put) or data (on get)e.g.
 * created empty buffer with size = 3   _,_,_
 *
 * get -> no data, buffer is empty (exception: non thread-save)
 * put 1 ->     1,_,_
 * put 2 ->     1,2,_
 * put 3 ->     1,2,3
 * put 4 ->     buffer is full  (exception: non thread-save)
 * get -> 1     _,2,3
 * put 4 ->     4,2,3
 * get -> 2     4,_,3
 * put 5 ->     4,5,3
 * get -> 3     4,5,_
 * put 6 ->     4,5,6
 */

public class RingBuffer {
    private int capacity = 0;
    private int size = 0;
    private int head = 0;
    private int tail = -1;

    private final Object[] data;


    public RingBuffer(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];

    }

//     * put 1 ->     1,_,_
//     * put 2 ->     1,2,_
//     * put 3 ->     1,2,3
//     * put 4 ->     buffer is full  (exception: non thread-save)
//     * get -> 1     _,2,3
//     * put 4 ->     4,2,3
//     * get -> 2     4,_,3

    public void put(Object element) throws FullBufferException {
        int index = (tail + 1) % capacity;

        size++;

        if (size > capacity) {
            throw new FullBufferException();
        }

        data[index] = element;
        tail++;
    }

    public Object get() {
        if (size == 0) {
            throw new EmptyBufferException();
        }

        int index = head % capacity;
        Object element = data[index];

        head++;
        size--;

        return element;
    }
}

