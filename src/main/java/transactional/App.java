package transactional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import transactional.service.ProductService;

/**
 * @author Sergei Aleshchenko
 */
public class App {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
        context.registerShutdownHook();
        ProductService productService = context.getBean("productService", ProductService.class);
        productService.saveProductInfo();

        context.close();
    }
}
