package selenium_express.microservices.employee_service.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import selenium_express.microservices.employee_service.entities.Employee;
import selenium_express.microservices.employee_service.repository.EmployeeRepository;
import selenium_express.microservices.employee_service.response.AddressResponse;
import selenium_express.microservices.employee_service.response.EmployeeResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergei Aleshchenko
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Value("${address.service.base.url}")
    private String addressBaseUrl;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            ModelMapper modelMapper,
            RestTemplateBuilder builder) {

        this.restTemplate = builder.build();
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());

        return employeeResponses;
    }

    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        AddressResponse addressResponse = restTemplate.getForObject(
                addressBaseUrl + "/address/{id}",
                AddressResponse.class, id);

        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }
}
