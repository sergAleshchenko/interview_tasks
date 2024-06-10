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

        Server server1 = simpleBoard.getNextServer();
        System.out.println("Request routed to server: " + server1.getIpAddress());

        Server server2 = simpleBoard.getNextServer();
        System.out.println("Request routed to server: " + server2.getIpAddress());

        Server server3 = simpleBoard.getNextServer();
        System.out.println("Request routed to server: " + server3.getIpAddress());
    }
}
