package selenium_express.microservices.address_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sergei Aleshchenko
 */
@RestController
public class AddressController {

    @GetMapping("/address")
    public String getAddress() {
        return "Lake road, Marathalli, Bangalore";
    }

}
