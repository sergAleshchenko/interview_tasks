package course;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(10);

        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));

        myLinkedList.remove(2);

        System.out.println(myLinkedList);

        myLinkedList.remove(2);

        System.out.println(myLinkedList);

        myLinkedList.remove(0);

        System.out.println(myLinkedList);

    }
}
