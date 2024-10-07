package selenium_express.microservices.employee_service_2.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import selenium_express.microservices.employee_service_2.response.AddressResponse;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
// http://localhost:8082/address-app/api/address/2
@FeignClient(name = "address-service", path = "/address-app/api/")
public interface AddressClient {

    @GetMapping("/address/{employeeId}")
    ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") Long id);

    @GetMapping("/address")
    ResponseEntity<List<AddressResponse>> getAllAddresses();

}