package selenium_express.microservices.employee_service.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import jakarta.persistence.*;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "inserttime")
    private Date insertTime;
}
