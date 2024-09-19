package selenium_express.microservices.employee_service.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import selenium_express.microservices.employee_service.entities.Employee;
import selenium_express.microservices.employee_service.repository.EmployeeRepository;
import selenium_express.microservices.employee_service.response.EmployeeResponse;

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

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());

        return employeeResponses;
    }

    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        return modelMapper.map(employee, EmployeeResponse.class);
    }
}
