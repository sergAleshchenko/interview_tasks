package lightspeed.entities;

import lombok.*;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Man {
    private String name;
    private int age;
    private List<String> favoriteBooks;
    private List<Car> cars;
}
