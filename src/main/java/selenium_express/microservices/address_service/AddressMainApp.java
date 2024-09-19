package selenium_express.microservices.address_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@PropertySources({
        @PropertySource(
                value = "classpath:selenium_express/microservices/configs/application-address.properties"),
        @PropertySource(
                value = "file:./selenium_express/microservices/configs/application-address.properties",
                ignoreResourceNotFound = true)
})
public class AddressMainApp {

    public static void main(String[] args) {
        SpringApplication.run(AddressMainApp.class, args);
    }
}
