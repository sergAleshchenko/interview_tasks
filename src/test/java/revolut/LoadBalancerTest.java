package revolut;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */

public class LoadBalancerTest {
    private LoadBalancer loadBalancer;

    @Before
    public void initServer() {
        loadBalancer = new LoadBalancer();

        loadBalancer.addServer("100.111.112.020");
    }


    @Test
    public void testLoad_ok() {
        Server nextServer = loadBalancer.getNextServer();

        Assert.assertNotNull(nextServer);
        Assert.assertEquals(nextServer.getIpAddress(), "100.111.112.020");
    }

    @Test
    public void testLoad_fail() {
        loadBalancer.clearAllServers();
        Assert.assertThrows(IllegalStateException.class, () -> loadBalancer.getNextServer());
    }

    @Test
    public void checkDuplicates() {
        Assert.assertThrows(IllegalStateException.class, () -> loadBalancer.addServer("100.111.112.020"));
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
                Assert.assertThrows(IllegalStateException.class, () -> loadBalancer.addServer("100.111.112.030"));

        Assert.assertEquals(exception.getMessage(), "The servers count is exceeded");
    }

}
