package hibernate_4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Sergei Aleshchenko
 */
@Entity
@Table(name="empoyee",
        schema="public",
        uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
@Getter
@Setter
@ToString
public class Employee1 {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="NAME", length=20, nullable=true)
    private String name;

    @Column(name="ROLE", length=20, nullable=true)
    private String role;

    @Column(name="insertTime", nullable=true)
    private Date insertTime;
}
