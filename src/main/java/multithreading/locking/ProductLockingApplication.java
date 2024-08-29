package multithreading.locking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Sergei Aleshchenko
 */
@SpringBootApplication
public class ProductLockingApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(ProductLockingApplication.class);

        ProductService service = context.getBean("productService", ProductService.class);
        service.createProductOptimistic(1L, 1000);
        ProductOptimistic foundProductOptimistic = service.getProductOptimistic(1L);
        System.out.println(foundProductOptimistic);
        service.updatePriceOptimistic(1L, 1500);
        ProductOptimistic foundNewProductOptimistic = service.getProductOptimistic(1L);
        System.out.println(foundNewProductOptimistic);


        service.createProductPessimistic(2L, 6000);
        ProductPessimistic productPessimistic = service.getProductPessimistic(2L);
        System.out.println(productPessimistic);
        service.updatePricePessimistic(2L, 8000);
        ProductPessimistic foundProductPessimistic = service.getProductPessimistic(2L);
        System.out.println(foundProductPessimistic);
    }
}
