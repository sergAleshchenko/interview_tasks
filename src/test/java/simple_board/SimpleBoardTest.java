package simple_board;

import interview_300_questions.simple_board.Server;
import interview_300_questions.simple_board.SimpleBoard;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Sergei Aleshchenko
 */
public class SimpleBoardTest {


    @Test
    public void getNextServerTest_ok() {
        SimpleBoard simpleBoard = new SimpleBoard();
        simpleBoard.addServer("192.168.1.10", 10);
        Server nextServer = simpleBoard.getNextServer();

        Assert.assertEquals(nextServer.getIpAddress(), "192.168.1.10");
    }

    @Test
    public void getNextServerTest_failed() {
        SimpleBoard simpleBoard = new SimpleBoard();
        IllegalStateException exception = Assert.assertThrows(IllegalStateException.class, () -> simpleBoard.getNextServer());

        Assert.assertEquals(exception.getMessage(), "No servers available in the load balancer.");
    }

    @Test
    public void requestToServer() {
        SimpleBoard simpleBoard = new SimpleBoard();
        simpleBoard.addServer("192.168.1.10", 22);
        Server nextServer = simpleBoard.getNextServer();

        Assert.assertEquals(nextServer.getCurrentLoad(), 23);
    }
}
