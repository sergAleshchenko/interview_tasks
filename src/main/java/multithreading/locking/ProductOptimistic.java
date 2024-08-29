package multithreading.locking;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Sergei Aleshchenko
 */

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductOptimistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private int version;


    private String name;

    private double price;

    public ProductOptimistic(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

