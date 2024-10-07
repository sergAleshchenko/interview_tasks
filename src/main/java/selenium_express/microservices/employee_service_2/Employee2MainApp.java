package selenium_express.microservices.employee_service_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author Sergei Aleshchenko
 */
@SpringBootApplication
@PropertySources({
        @PropertySource(
                value = "classpath:selenium_express/microservices/configs/application-employee-2.properties"),
        @PropertySource(
                value = "file:./selenium_express/microservices/configs/application-employee-2.properties",
                ignoreResourceNotFound = true)
})
@EnableFeignClients
public class Employee2MainApp {
    public static void main(String[] args) {
        SpringApplication.run(Employee2MainApp.class, args);
    }
}
