package evgeny_borisov.spring_data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Date;

/**
 * @author Sergei Aleshchenko
 */
@Entity
public class Talk {

    @Id
    @GeneratedValue
    private Long talkId;

    @Getter
    private Date when;

    private String title;

    public Talk() {
    }

    public Talk(Date when, String title) {
        this.when = when;
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
