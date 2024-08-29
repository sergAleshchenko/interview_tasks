package multithreading.locking;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

/**
 * @author Sergei Aleshchenko
 */
public interface ProductPessimisticRepository extends JpaRepository<ProductPessimistic, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<ProductPessimistic> findByIdLocked(Long id);
}
