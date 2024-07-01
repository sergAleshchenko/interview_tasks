package hibernate_6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.ZonedDateTime;

/**
 * @author Sergei Aleshchenko
 */
@Entity
@Table(name = "Books")
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    private ZonedDateTime date;


    public Book(String name, String description, ZonedDateTime date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }
}
