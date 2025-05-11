package others;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

public class ArrayDequeMain {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();


        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println();

        BitSet bitSet = new BitSet(5);


        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(11);
        queue.offer(22);
        queue.offer(33);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
