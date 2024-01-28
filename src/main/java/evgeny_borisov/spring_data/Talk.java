package evgeny_borisov.spring_data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * @author Sergei Aleshchenko
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Talk {

    @Id
    @GeneratedValue
    @Column(name = "`talkid`")
    private Long talkId;

    @Column(name = "`talkdate`")
    private Date when;

    @Column(name = "`talktitle`")
    private String title;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="speaker_id", nullable=false)
    private Speaker speaker;

    @Override
    public String toString() {
        return title + " -> " + when.toString();
    }
}
