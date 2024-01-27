package evgeny_borisov.spring_data;

import org.apache.derby.jdbc.EmbeddedDriver;
import org.h2.engine.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
@ComponentScan
public class AppConfig {
}
