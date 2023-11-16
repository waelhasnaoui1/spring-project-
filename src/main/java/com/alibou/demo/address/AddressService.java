package com.alibou.demo.address;

import com.alibou.demo.subject.Subject;

import java.util.List;

public interface AddressService {
    Address save(Address address);

    Address findById(int id);

    List<Address> findAll();

    void deleteById(Integer id);

    void update(Address address);
}
