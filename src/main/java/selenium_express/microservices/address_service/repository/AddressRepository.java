package selenium_express.microservices.address_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import selenium_express.microservices.address_service.entities.Address;

/**
 * @author Sergei Aleshchenko
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(nativeQuery = true, value = "select ea.id, ea.state, ea.city, ea.street, ea.zip from Address ea join Employee e on ea.id = e.id where ea.id = :employeeId")
    Address findAddressByEmployeeId(@Param("employeeId") Long employeeId);
}
