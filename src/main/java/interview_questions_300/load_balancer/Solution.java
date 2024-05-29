package interview_questions_300.load_balancer;

import java.io.IOException;

/**
 * @author Sergei Aleshchenko
 */
public class Solution {

    void doSomething() throws NullPointerException {

    }
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer();

        loadBalancer.addServer("192.168.1.10", 10);
        loadBalancer.addServer("192.168.1.11", 8);
        loadBalancer.addServer("192.168.1.12", 13);

        String ipAddress1 = loadBalancer.getNextServer();
        System.out.println("Request routed to server: " + ipAddress1);

        String ipAddress2 = loadBalancer.getNextServer();
        System.out.println("Request routed to server: " + ipAddress2);

        String ipAddress3 = loadBalancer.getNextServer();
        System.out.println("Request routed to server: " + ipAddress3);

        try {
            throw new ClassNotFoundException();
        } catch (ArithmeticException e) {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
