package selenium_express.microservices.employee_service_2.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import selenium_express.microservices.employee_service_2.entities.Employee;
import selenium_express.microservices.employee_service_2.feign.AddressClient;
import selenium_express.microservices.employee_service_2.repository.EmployeeRepository;
import selenium_express.microservices.employee_service_2.response.AddressResponse;
import selenium_express.microservices.employee_service_2.response.EmployeeResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergei Aleshchenko
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final AddressClient addressClient;

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());

        return employeeResponses;
    }

    // RestClient and WebClient are not recommended for use
    // Spring recommend to use FeignClient
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        ResponseEntity<AddressResponse> addressResponseResponseEntity =
                addressClient.getAddressByEmployeeId(id);

        AddressResponse addressResponse = addressResponseResponseEntity.getBody();
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }
}
