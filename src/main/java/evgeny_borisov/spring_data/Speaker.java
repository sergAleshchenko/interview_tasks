package evgeny_borisov.spring_data;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergei Aleshchenko
 */
@Entity
public class Speaker {

    @Id
    @GeneratedValue
    private Long speakerId;

    @Getter
    private String name;

    @Getter
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Talk> talks;

    public Speaker() {
    }

    public Speaker(String name) {
        this.name = name;
    }

    public void addTalk(Talk talk) {
        if (talks == null) talks = new HashSet<>();
        talks.add(talk);
    }

    @Override
    public String toString() {
        return "Speaker{" +"name='" + name + '\'' + '}';
    }
}
