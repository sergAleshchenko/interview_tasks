package multithreading.locking;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Aleshchenko
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductOptimisticRepository productOptimisticRepository;
    private final ProductPessimisticRepository productPessimisticRepository;

    public void createProductOptimistic(Long id, double price) {
        productOptimisticRepository.save(new ProductOptimistic(id, "Some name", price));
    }

    public ProductOptimistic getProductOptimistic(Long id) {
        return productOptimisticRepository.findById(id).orElseThrow();
    }

    public void updatePriceOptimistic(Long id, double newPrice) {
        ProductOptimistic productOptimistic = productOptimisticRepository.findById(id).orElseThrow();
        productOptimistic.setPrice(newPrice);
        productOptimisticRepository.save(productOptimistic);
    }


    public ProductPessimistic getProductPessimistic(Long id) {
        return productPessimisticRepository.findById(id).orElseThrow();
    }


    public void createProductPessimistic(Long id, double price) {
        productPessimisticRepository.save(new ProductPessimistic(id, "Some name", price));
    }


    public void updatePricePessimistic(Long id, double newPrice) {
        ProductPessimistic productPessimistic =
                productPessimisticRepository
                        .findById(id)
                        .orElseThrow(EntityNotFoundException::new);

        productPessimistic.setPrice(newPrice);
        productPessimisticRepository.save(productPessimistic);
    }
}
