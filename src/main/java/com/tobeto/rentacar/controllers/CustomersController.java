package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {

    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id)
    {
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @PutMapping
    public void update(@RequestBody Customer customer){
        customerRepository.findById(customer.getId()).orElseThrow();
        customerRepository.save(customer);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        customerRepository.deleteById(id);
    }


}
