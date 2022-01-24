package com.example.team1.service;

import com.example.team1.DAO.Dao.AddressDao;
import com.example.team1.domain.AddressDomain;
import com.example.team1.entity.Address;
import com.example.team1.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    @Transactional
    public List<AddressDomain> getAddressByPersonId(Person person){
        Optional<List<Address>> optional = Optional.ofNullable(addressDao.getAddressListByPersonId(person));
        if (optional.isPresent()){
            return optional.get().stream().map(
                    address -> new AddressDomain(address.getAddressLine1(),
                            address.getAddressLine2(),
                            address.getCity(),
                            address.getState(),
                            address.getZipcode(),
                            address.getPerson().getId(),address.getId())).collect(Collectors.toList());
        }
        return null;
    }

    @Transactional
    public void updateAddress(List<AddressDomain> addressDomains, Person person){
        List<Address> addressList = addressDao.getAddressListByPersonId(person);
        if(addressList!=null && !addressList.isEmpty() && addressDomains!=null && !addressDomains.isEmpty()){
            for(int i = 0;i<addressDomains.size();i++){
                AddressDomain addressDomain = addressDomains.get(i);
                if(i<addressList.size()){
                    Address address = addressList.get(i);
                    address.setAddressLine1(addressDomain.getAddressLine1());
                    address.setAddressLine2(addressDomain.getAddressLine2());
                    address.setCity(addressDomain.getCity());
                    address.setState(addressDomain.getState());
                    address.setZipcode(addressDomain.getZipcode());
                    addressDao.updateAddress(address);
                }else {
                    addAddress(addressDomain, person);
                }
            }
        }
    }

    @Transactional
    public void addAddress(AddressDomain addressDomain, Person person){
        Address address = new Address();
        address.setAddressLine1(addressDomain.getAddressLine1());
        address.setAddressLine2(addressDomain.getAddressLine2());
        address.setCity(addressDomain.getCity());
        address.setState(addressDomain.getState());
        address.setZipcode(addressDomain.getZipcode());
        address.setPerson(person);
        addressDao.addNewAddress(address);
    }
}
