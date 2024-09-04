package transactional.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import transactional.Product;

/**
 * @author Sergei Aleshchenko
 */
@Repository
@RequiredArgsConstructor
public class ProductRepo {

    private final JdbcTemplate jdbcTemplate;


    @Transactional
    public void saveProduct(Product product) {
        String sql = "INSERT INTO PRODUCT VALUES (?,?,?,?)";

        Object[] args = {product.getId(), product.getVersion(), product.getName(), product.getPrice()};

        jdbcTemplate.update(sql, args);
        System.out.println("Product saved...");
    }
}
