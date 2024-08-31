package multithreading.locking;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Sergei Aleshchenko
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Version
    private Long version;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
