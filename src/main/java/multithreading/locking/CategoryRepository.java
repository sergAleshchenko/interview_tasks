package multithreading.locking;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Override
    @Lock(value = LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    Optional<Category> findById(Integer integer);

}
