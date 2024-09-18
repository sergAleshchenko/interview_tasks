package selenium_express.microservices.employee_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sergei Aleshchenko
 */
@RestController
public class EmployeeController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/employee")
    public String getEmployee() {
        String address = restTemplate.getForObject("http://localhost:8081/address", String.class);

        return "Name: Abhilash, email: abhialsh@gmail.com, address: " + address;
    }


}
