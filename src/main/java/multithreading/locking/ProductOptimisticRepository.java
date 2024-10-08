package multithreading.locking;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
public interface ProductOptimisticRepository extends JpaRepository<ProductOptimistic, Long> {
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Override
    Optional<ProductOptimistic> findById(Long id);
}
