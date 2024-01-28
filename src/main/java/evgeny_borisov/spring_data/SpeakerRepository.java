package evgeny_borisov.spring_data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



/**
 * @author Sergei Aleshchenko
 */
@Repository
public interface SpeakerRepository extends CrudRepository<Speaker, Long> {

}
