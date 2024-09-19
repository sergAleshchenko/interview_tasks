package selenium_express.microservices.address_service.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import selenium_express.microservices.address_service.entities.Address;
import selenium_express.microservices.address_service.repository.AddressRepository;
import selenium_express.microservices.address_service.response.AddressResponse;

/**
 * @author Sergei Aleshchenko
 */
@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;


    public AddressResponse getAddressByEmployeeId(Long id) {
        Address address = addressRepository.findAddressByEmployeeId(id);

        return modelMapper.map(address, AddressResponse.class);
    }
}
