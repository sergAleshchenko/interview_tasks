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
public class ProductPessimistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;

    public ProductPessimistic(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
