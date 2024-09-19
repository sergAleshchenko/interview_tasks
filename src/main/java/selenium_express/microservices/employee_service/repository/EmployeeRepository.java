package selenium_express.microservices.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selenium_express.microservices.employee_service.entities.Employee;

/**
 * @author Sergei Aleshchenko
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
