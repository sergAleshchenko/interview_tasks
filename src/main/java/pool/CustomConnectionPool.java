package pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum CustomConnectionPool {
    INSTANCE;

    private BlockingQueue<Connection> freeConnections;
    private Queue<Connection> givenAwayConnections;

    private final static int DEFAULT_POOL_SIZE = 32;

    CustomConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        givenAwayConnections = new ArrayDeque<>();
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = freeConnections.take();
            givenAwayConnections.offer(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void releaseConnection(Connection connection) {
        givenAwayConnections.remove(connection);
        freeConnections.offer(connection);
    }

    public void destroyPool() {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            try {
                freeConnections.take().close();
            } catch (SQLException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers() {
//        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
//            try {
//                DriverManager.deregisterDriver(driver);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        });
    }
}
