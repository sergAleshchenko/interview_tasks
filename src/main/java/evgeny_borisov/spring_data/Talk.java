package evgeny_borisov.spring_data;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Parent;

import java.util.Date;

/**
 * @author Sergei Aleshchenko
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Talk {

    @Id
    @GeneratedValue
    @Column(name = "`TALK_ID`")
    private Long talkId;

    @Column(name = "`WHEN`")
    private Date when;

    @Column(name = "`TITLE`")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="speakerId", nullable=false)
    private Speaker speaker;
}
