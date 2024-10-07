package selenium_express.microservices.address_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import selenium_express.microservices.address_service.response.AddressResponse;
import selenium_express.microservices.address_service.services.AddressService;

import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        List<AddressResponse> allAddresses = addressService.getAllAddresses();

        return ResponseEntity.status(HttpStatus.OK).body(allAddresses);
    }

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") Long id) {

        AddressResponse addressResponse = addressService.getAddressByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

}
