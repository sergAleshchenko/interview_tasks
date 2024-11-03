package selenium_express.microservices.employee_service.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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
    private final AddressClient addressClient;
    private final DiscoveryClient discoveryClient;
    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

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

        List<ServiceInstance> instances = discoveryClient.getInstances("address-service");

        instances.stream().forEach(serviceInstance -> {
            String contextRoot = serviceInstance.getMetadata().get("configPath");
            String contextUser = serviceInstance.getMetadata().get("user");

            System.out.println("contextRoot: " + contextRoot);
            System.out.println("contextUser: " + contextUser);
            System.out.println(serviceInstance.getUri().toString());

        });

        ResponseEntity<AddressResponse> addressResponseResponseEntity =
                addressClient.getAddressByEmployeeId(id);

        AddressResponse addressResponse = addressResponseResponseEntity.getBody();
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }

    public AddressResponse callingAddressService(Long id) {
        return restTemplate.getForObject("http://address-service/{id}", AddressResponse.class, id);
    }
}
