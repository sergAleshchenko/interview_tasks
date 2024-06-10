package revolut;

/**
 * @author Sergei Aleshchenko
 */
public class Solution {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer();

        loadBalancer.addServer("100.111.112.020");
        loadBalancer.addServer("100.111.112.021");
        loadBalancer.addServer("100.111.112.022");
        loadBalancer.addServer("100.111.112.023");
        loadBalancer.addServer("100.111.112.024");


        System.out.println("Request to " + loadBalancer.getNextServer());
        System.out.println("Request to " + loadBalancer.getNextServer());
        System.out.println("Request to " + loadBalancer.getNextServer());
        System.out.println("Request to " + loadBalancer.getNextServer());
    }
}
