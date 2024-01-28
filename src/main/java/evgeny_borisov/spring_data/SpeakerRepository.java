package evgeny_borisov.spring_data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * @author Sergei Aleshchenko
 */
@Repository
public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

    Optional<Speaker> findByName(String name);

    List<Speaker> findByNameLike(String nameLike);

    List<Speaker> findByNameEndingWith(String suffix);

    List<Speaker> findByTalksTitleLikeIgnoreCase(String partOfTalkTitle);

    List<Speaker> findByTalksWhenBetween(Date from, Date to);
}
