package com.alibou.demo.address.impl;

import com.alibou.demo.address.Address;
import com.alibou.demo.address.AddressRepository;
import com.alibou.demo.address.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(int id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void update(Address address) {
        Address existAddress = findById(address.getId());

        if (existAddress != null){
            existAddress.setHomeAddress(address.getHomeAddress());
            existAddress.setStudent(address.getStudent());


            addressRepository.save(existAddress);
        }
    }
}
