package selenium_express.microservices.employee_service.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import selenium_express.microservices.employee_service.entities.Employee;
import selenium_express.microservices.employee_service.feign.AddressClient;
import selenium_express.microservices.employee_service.repository.EmployeeRepository;
import selenium_express.microservices.employee_service.response.EmployeeResponse;
import selenium_express.microservices.employee_service.response.AddressResponse;

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
    private final WebClient webClient;
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

//        AddressResponse addressResponse = webClient
//                .get()
//                .uri("/address/" + id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .block();

        ResponseEntity<AddressResponse> addressResponseResponseEntity =
                addressClient.getAddressByEmployeeId(id);

        AddressResponse addressResponse = addressResponseResponseEntity.getBody();
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }
}
