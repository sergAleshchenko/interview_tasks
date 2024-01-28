package evgeny_borisov.spring_data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
public interface TalkRepository extends CrudRepository<Talk, Long> {
    Optional<Talk> findByTitle(String name);

    List<Talk> findByTitleLike(String titleLike);

    List<Talk> findByTitleEndingWith(String suffix);
}
