package selenium_express.microservices.employee_service.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
public class AddressResponse {
    private Long id;
    private String state;
    private String city;
    private String street;
    private String zip;
}
