package selenium_express.microservices.employee_service_2.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Sergei Aleshchenko
 */
@Getter
@Setter
public class EmployeeResponse {
    private Long id;
    private String name;
    private String role;
    private Date insertTime;
    private AddressResponse addressResponse;
}
