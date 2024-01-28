package evgeny_borisov.spring_data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergei Aleshchenko
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Speaker {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long speakerId;

    @Getter
    @Column(name = "speakername")
    private String name;

    @Getter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "speaker", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Talk> talks;

    public Speaker(String name) {
        this.name = name;
    }

    public void addTalk(Talk talk) {
        if (talks == null) talks = new HashSet<>();
        talks.add(talk);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("**************** ");
        sb.append(name).append(", ");

        for (Talk talk : talks) {
            sb.append(" ").append(talk.toString()).append(", ");
        }

        return sb.toString();
    }
}
