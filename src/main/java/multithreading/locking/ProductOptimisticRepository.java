package multithreading.locking;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergei Aleshchenko
 */
public interface ProductOptimisticRepository extends JpaRepository<ProductOptimistic, Long> {

}
