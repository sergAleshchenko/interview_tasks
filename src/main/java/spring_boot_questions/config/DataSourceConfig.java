package spring_boot_questions.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class DataSourceConfig {

    private String username;
    private String password;

}
