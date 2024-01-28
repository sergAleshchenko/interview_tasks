package evgeny_borisov.spring_data;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergei Aleshchenko
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Speaker {

    @Id
    @GeneratedValue
    @Column(name = "SPEAKER_ID")
    private Long speakerId;

    @Getter
    @Column(name = "SPEAKER_NAME")
    private String name;

    @Getter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "speaker", cascade = CascadeType.ALL)
    private Set<Talk> talks;

    public Speaker(String name) {
        this.name = name;
    }

    public void addTalk(Talk talk) {
        if (talks == null) talks = new HashSet<>();
        talks.add(talk);
    }
}
