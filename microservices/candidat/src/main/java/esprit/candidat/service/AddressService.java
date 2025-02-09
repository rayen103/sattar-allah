package esprit.candidat.service;

import esprit.candidat.condidatRepo.AddressRepo;
import esprit.candidat.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public List<Address> findAll() {
        return addressRepo.findAll();
    }

    public Optional<Address> findById(int id) {
        return addressRepo.findById(id);
    }

    public Address save(Address address) {
        return addressRepo.save(address);
    }

    public Address update(int id, Address addressDetails) {
        return addressRepo.findById(id).map(address -> {
            address.setStreet(addressDetails.getStreet());
            address.setHouseNumber(addressDetails.getHouseNumber());
            address.setZipCode(addressDetails.getZipCode());
            return addressRepo.save(address);
        }).orElseThrow(() -> new RuntimeException("Address not found with id " + id));
    }

    public void delete(int id) {
        addressRepo.deleteById(id);
    }
}
