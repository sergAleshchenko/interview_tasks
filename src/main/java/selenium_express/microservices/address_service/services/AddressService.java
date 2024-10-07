package selenium_express.microservices.address_service.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import selenium_express.microservices.address_service.entities.Address;
import selenium_express.microservices.address_service.repository.AddressRepository;
import selenium_express.microservices.address_service.response.AddressResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergei Aleshchenko
 */
@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;


    public AddressResponse getAddressByEmployeeId(Long id) {

        System.out.println("Finding address for employee: " + id);
        Address address = addressRepository.findAddressByEmployeeId(id);

        return modelMapper.map(address, AddressResponse.class);
    }

    public List<AddressResponse> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();

        List<AddressResponse> addressResponses = addresses.stream()
                .map(address -> modelMapper.map(address, AddressResponse.class))
                .collect(Collectors.toList());

        return addressResponses;
    }
}
