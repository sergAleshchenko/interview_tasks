package interview_300_questions.simple_board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
@Getter
@Setter
public class Server {
    private String ipAddress;
    private int currentLoad;

    public void incrementLoad() {
        currentLoad++;
    }
}
