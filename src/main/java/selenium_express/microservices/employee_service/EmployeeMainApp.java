package selenium_express.microservices.employee_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author Sergei Aleshchenko
 */
@SpringBootApplication
@PropertySources({
        @PropertySource(
                value = "classpath:selenium_express/microservices/configs/application-employee.properties"),
        @PropertySource(
                value = "file:./selenium_express/microservices/configs/application-employee.properties",
                ignoreResourceNotFound = true)
})
@EnableFeignClients
public class EmployeeMainApp {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeMainApp.class, args);
    }
}
