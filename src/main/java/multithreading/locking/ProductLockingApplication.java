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

        ProductService productService = context.getBean("productService", ProductService.class);
        CategoryService categoryService = context.getBean("categoryService", CategoryService.class);


        productService.createProductOptimistic(1L, 1000);
        ProductOptimistic foundProductOptimistic = productService.getProductOptimistic(1L);
        System.out.println(foundProductOptimistic);
        productService.updatePriceOptimistic(1L, 1500);
        ProductOptimistic foundNewProductOptimistic = productService.getProductOptimistic(1L);
        System.out.println(foundNewProductOptimistic);


//        productService.createProductPessimistic(2L, 6000);
//        ProductPessimistic productPessimistic = productService.getProductPessimistic(2L);
//        System.out.println(productPessimistic);
//        productService.updatePricePessimistic(2L, 8000);
//        ProductPessimistic foundProductPessimistic = productService.getProductPessimistic(2L);
//        System.out.println(foundProductPessimistic);

        categoryService.createCategory(1, "Some category name");
        Category foundCategory = categoryService.getCategoryById(1);
        System.out.println(foundCategory);

    }
}
