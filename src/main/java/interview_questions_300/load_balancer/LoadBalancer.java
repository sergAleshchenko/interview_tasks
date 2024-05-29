package interview_questions_300.load_balancer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class LoadBalancer {

    private List<Server> servers;

    public LoadBalancer() {
        servers = new ArrayList<>();
    }

    public void addServer(String ipAddress, int currentLoad) {
        servers.add(new Server(ipAddress, currentLoad));
    }

    public String getNextServer() {
        if (servers.isEmpty()) {
            throw new IllegalStateException("No servers available in the load balancer.");
        }

        Server minLoadServer = servers.get(0);
        for (Server server : servers) {
            if (server.getCurrentLoad() < minLoadServer.getCurrentLoad()) {
                minLoadServer = server;
            }
        }

        minLoadServer.incrementLoad();

        return minLoadServer.getIpAddress();
    }
}
