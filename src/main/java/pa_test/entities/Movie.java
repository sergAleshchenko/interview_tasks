package pa_test.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
@AllArgsConstructor
public class Movie {
    private String name;
    private String director;
    private float rating;
}
