package kubernetes_demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
@Getter
@Setter
public class StudentInformation {
    private int id;
    private String firstName;
    private String lastName;
}
