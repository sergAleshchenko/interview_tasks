package transactional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transactional.Product;
import transactional.repository.ProductRepo;

/**
 * @author Sergei Aleshchenko
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    @Transactional
    public void saveProductInfo() {

        for (int i = 1; i <= 10; i++) {
            Product product = new Product(i, "Test Product " + i, i, i + 10);

            productRepo.saveProduct(product);

//            if (i == 7) {
//                throw new RuntimeException("Some error occured...");
//            }
        }
    }
}
