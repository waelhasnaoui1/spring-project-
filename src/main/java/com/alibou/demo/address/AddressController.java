package com.alibou.demo.address;

import com.alibou.demo.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping()
    public List<Address> getAllSubjects(){
        return addressService.findAll();
    }

    @GetMapping("{id}")
    public Address getSubjectById(@PathVariable("id") int id){
        return addressService.findById(id);
    }

    @PostMapping()
    public Address crateChapter (@RequestBody Address address){
        return addressService.save(address);
    }

    @DeleteMapping("{id}")
    public void deleteChapter (@PathVariable("id") int id){
        addressService.deleteById(id);
    }
}
