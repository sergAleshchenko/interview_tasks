package interview_300_questions.simple_board;

/**
 * @author Sergei Aleshchenko
 */
public class Solution {

    void doSomething() throws NullPointerException {

    }
    public static void main(String[] args) {
        SimpleBoard simpleBoard = new SimpleBoard();

        simpleBoard.addServer("192.168.1.10", 10);
        simpleBoard.addServer("192.168.1.11", 8);
        simpleBoard.addServer("192.168.1.12", 13);

        String ipAddress1 = simpleBoard.getNextServer();
        System.out.println("Request routed to server: " + ipAddress1);

        String ipAddress2 = simpleBoard.getNextServer();
        System.out.println("Request routed to server: " + ipAddress2);

        String ipAddress3 = simpleBoard.getNextServer();
        System.out.println("Request routed to server: " + ipAddress3);

        try {
            throw new ClassNotFoundException();
        } catch (ArithmeticException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
