package revolut;


import java.util.*;

/**
 * @author Sergei Aleshchenko
 */
public class LoadBalancer {

    private List<Server> servers;
    private final int maxCountOfServers = 10;


    public LoadBalancer() {
        servers = new ArrayList<>();
    }

    public void addServer(String serverIp) {

        // O(n)
        for (Server server : servers) {
            if (server.getIpAddress().equals(serverIp)) {
                throw new IllegalStateException("The server has already exists");
            }
        }

        // O(1)
        if (servers.size() < 10) {
            servers.add(new Server(serverIp));
        } else {
            throw new IllegalStateException("The servers count is exceeded");
        }
    }

    public void clearAllServers() {
        servers.clear();
    }

    public Server getNextServer() {
        // O(1)
        if (servers.isEmpty()) {
            throw new IllegalStateException("We don't have any servers");
        }

        Random random = new Random();

        // O(1)
        return servers.get(random.nextInt(servers.size()));
    }

    @Override
    public String toString() {
        return "LoadBalancer{" +
                "servers=" + servers +
                ", maxCountOfServers=" + maxCountOfServers +
                '}';
    }
}
