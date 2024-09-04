package transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Sergei Aleshchenko
 */

@Configuration
@ComponentScan("transactional")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class ProductConfig {
    
    @Bean
    public DataSource dataSource(){
        return new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/hibernate_demo_db",
                "serga",
                "admin1234");
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
