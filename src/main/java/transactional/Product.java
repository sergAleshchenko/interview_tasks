package transactional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
@AllArgsConstructor
public class Product {

    private Integer id;
    private String name;
    private Integer version;
    private Integer price;
}
