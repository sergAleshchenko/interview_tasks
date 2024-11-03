package selenium_express.microservices.employee_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import selenium_express.microservices.employee_service.response.AddressResponse;
import selenium_express.microservices.employee_service.response.EmployeeResponse;
import selenium_express.microservices.employee_service.services.EmployeeService;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        List<EmployeeResponse> employeeResponses = employeeService.getAllEmployees();

        return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable Long id) {
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
//        AddressResponse addressResponse = employeeService.callingAddressService(id);

        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }
}
