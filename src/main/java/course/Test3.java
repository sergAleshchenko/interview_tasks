package course;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class Test3 {
    public static void main(String[] args) {
        List<Person3> peopleList = new ArrayList<>();
        Set<Person3> peopleSet = new TreeSet<>();

        Queue<Person3> peopleQueue = new LinkedList<>();
        ArrayBlockingQueue<Person3> peopleBlockQueue
                = new ArrayBlockingQueue<Person3>(3);

        Stack<Integer> stack = new Stack<>();


        addElements(peopleList);
        addElements(peopleSet);
        addElements(peopleQueue);
//        addElementsArrayBlockQueue(peopleBlockQueue);
        addStackElements(stack);

//        Collections.sort(peopleList);
//        printElements(peopleList);
//        printElements(peopleSet);

//        printElements(peopleQueue);

//        printElements(peopleBlockQueue);
//        System.out.println(peopleBlockQueue.remove());
//        System.out.println("--------------------------");
//        printElements(peopleBlockQueue);
//        System.out.println("--------------------------");
//        System.out.println(peopleBlockQueue.peek());
//        System.out.println("--------------------------");
//        printElements(peopleBlockQueue);
        printStackElements(stack);
    }

    private static void addElements(Collection collection) {
        collection.add(new Person3(7, "Tom"));
        collection.add(new Person3(2, "B"));
        collection.add(new Person3(8, "John"));
        collection.add(new Person3(4, "George"));
        collection.add(new Person3(1, "Mi"));
    }

    private static void addElementsArrayBlockQueue(ArrayBlockingQueue queue) {
        System.out.println(queue.offer(new Person3(7, "Tom")));
        System.out.println(queue.offer(new Person3(2, "B")));
        System.out.println(queue.offer(new Person3(8, "John")));
        System.out.println(queue.offer(new Person3(4, "George")));
        System.out.println(queue.offer(new Person3(1, "Mi")));
    }

    private static void addStackElements(Stack stack) {
        stack.push(new Person3(7, "Tom"));
        stack.push(new Person3(2, "B"));
        stack.push(new Person3(8, "John"));
        stack.push(new Person3(4, "George"));
        stack.push(new Person3(1, "Mi"));
    }

    private static void printElements(Collection collection) {
        for (Object element : collection) {
            System.out.println(element);
        }
        System.out.println("--------------------------------");
    }

    private static void printStackElements(Stack stack) {
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println("--------------------------------");
    }
}

class Person3 implements Comparable<Person3> {
    private int id;
    private String name;

    public Person3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person3 person3 = (Person3) o;

        if (id != person3.id) return false;
        return name != null ? name.equals(person3.name) : person3.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person3 o) {
        return Integer.compare(this.name.length(), o.getName().length());
    }
}
