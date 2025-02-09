package epam;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author Sergei Aleshchenko
 */

// main operations: add(element), remove(element), contains, clear, isEmpty
// autoresize: Arrays.copyOf(arr, size * 2)
// multithreading (?)

@Getter
public class CustomSet {

    private int[] array;
    private int size;
    private int capacity;

    public CustomSet(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }


    public boolean contains(int value) {
        for (int element : array) {
            if(value == element) {
                return true;
            }
        }

        return false;
    }

    public void add(int element) {
        if (contains(element)) {
            return;
        }
        if (size >= capacity) {
            capacity = capacity * 2;
            array = Arrays.copyOf(array, capacity);
        }
        array[size++] = element;
    }

    public boolean remove(int element) {
        if(size == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                array[i] = array[size - 1];
                size --;
                return true;
            }
        }

        return false;
    }

    public void clear() {
        size = 0;
        array = new int[size];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
