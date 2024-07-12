package prodly;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sergei Aleshchenko
 */
public class DiveTree {

    private static void printTree(Node root) {
        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Iterator<Node> iter = currentLevel.iterator();

            while (iter.hasNext()) {
                Node currentNode = iter.next();

                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                System.out.print(currentNode.data + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);

        printTree(root);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
