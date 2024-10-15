package selenium_express.microservices.employee_service.config;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Sergei Aleshchenko
 */
@Configuration
@RequiredArgsConstructor
public class EmployeeConfiguration {
    @Value("${address.service.base.url}")
    private String addressBaseUrl;

    private final RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder
                .rootUri(addressBaseUrl)
                .build();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(addressBaseUrl)
                .build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public String baseUrl() {
        return addressBaseUrl;
    }
}
