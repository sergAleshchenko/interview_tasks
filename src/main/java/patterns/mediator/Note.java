package patterns.mediator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Sergei Aleshchenko
 */
@Setter
@Getter
public class Note {
    private String name;
    private String text;

    public Note() {
        name = "New note";
    }

    @Override
    public String toString() {
        return name;
    }
}
