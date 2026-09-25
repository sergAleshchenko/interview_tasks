package revolut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sergei Aleshchenko
 */

public class LoadBalancerTest {
    private LoadBalancer loadBalancer;

    @BeforeEach
    public void initServer() {
        loadBalancer = new LoadBalancer();

        loadBalancer.addServer("100.111.112.020");
    }


    @Test
    public void testLoad_ok() {
        Server nextServer = loadBalancer.getNextServer();

        assertNotNull(nextServer);
        assertEquals("100.111.112.020", nextServer.getIpAddress());
    }

    @Test
    public void testLoad_fail() {
        loadBalancer.clearAllServers();
        assertThrows(IllegalStateException.class, () -> loadBalancer.getNextServer());
    }

    @Test
    public void checkDuplicates() {
        assertThrows(IllegalStateException.class, () -> loadBalancer.addServer("100.111.112.020"));
    }

    @Test
    public void exceedServersCount () {
        loadBalancer.addServer("100.111.112.021");
        loadBalancer.addServer("100.111.112.022");
        loadBalancer.addServer("100.111.112.023");
        loadBalancer.addServer("100.111.112.024");
        loadBalancer.addServer("100.111.112.025");
        loadBalancer.addServer("100.111.112.026");
        loadBalancer.addServer("100.111.112.027");
        loadBalancer.addServer("100.111.112.028");
        loadBalancer.addServer("100.111.112.029");

        IllegalStateException exception =
                assertThrows(IllegalStateException.class, () -> loadBalancer.addServer("100.111.112.030"));

        assertEquals("The servers count is exceeded", exception.getMessage());
    }


    @Test
    public void newlyCreatedBalancerRejectsSelection() {
        LoadBalancer emptyBalancer = new LoadBalancer();

        assertThrows(IllegalStateException.class, emptyBalancer::getNextServer);
    }

    @Test
    public void selectionOnlyReturnsRegisteredServers() {
        loadBalancer.addServer("100.111.112.021");
        loadBalancer.addServer("100.111.112.022");
        Set<String> registeredIps = Set.of(
                "100.111.112.020", "100.111.112.021", "100.111.112.022");

        // Check membership, not random order or frequency, to avoid flaky tests.
        for (int i = 0; i < 100; i++) {
            Server selected = loadBalancer.getNextServer();
            assertNotNull(selected);
            assertTrue(registeredIps.contains(selected.getIpAddress()));
        }
    }

    @Test
    public void rejectedDuplicateDoesNotConsumeCapacity() {
        assertThrows(IllegalStateException.class,
                () -> loadBalancer.addServer("100.111.112.020"));

        for (int i = 21; i <= 29; i++) {
            String ip = "100.111.112.0" + i;
            assertDoesNotThrow(() -> loadBalancer.addServer(ip));
        }
        assertThrows(IllegalStateException.class,
                () -> loadBalancer.addServer("100.111.112.030"));
    }

    @Test
    public void clearingFullBalancerRestoresAllTenSlots() {
        for (int i = 21; i <= 29; i++) {
            loadBalancer.addServer("100.111.112.0" + i);
        }

        loadBalancer.clearAllServers();

        assertThrows(IllegalStateException.class, loadBalancer::getNextServer);
        for (int i = 1; i <= 10; i++) {
            String ip = "192.168.1." + i;
            assertDoesNotThrow(() -> loadBalancer.addServer(ip));
        }
        assertThrows(IllegalStateException.class,
                () -> loadBalancer.addServer("192.168.1.11"));
    }

    @Test
    public void clearedServerCanBeRegisteredAgain() {
        loadBalancer.clearAllServers();

        assertDoesNotThrow(() -> loadBalancer.addServer("100.111.112.020"));

        assertEquals("100.111.112.020", loadBalancer.getNextServer().getIpAddress());
    }

}
