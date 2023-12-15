package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.rentacar.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.rentacar.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.rentacar.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.rentacar.entities.Customer;
import com.tobeto.rentacar.entities.User;
import com.tobeto.rentacar.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
    private final CustomerRepository customerRepository;

    public CustomersController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<GetCustomerListResponse> getAll(){

        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customer -> {
            GetCustomerListResponse response = new GetCustomerListResponse();
            response.setId(customer.getId());
            response.setName(customer.getUser().getFirstname() + " " + customer.getUser().getLastname());
            return response;
        }).toList();
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id) {

        Customer customer = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse response = new GetCustomerResponse();

        response.setName(customer.getUser().getFirstname() + " " + customer.getUser().getLastname());

        return response;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request){

        Customer customer = new Customer();

        User user = new User();
        user.setId(request.getUserId());
        customer.setUser(user);


        customerRepository.save(customer);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest request){

        Customer customer = customerRepository.findById(id).orElseThrow();

        User user = new User();
        user.setId(request.getUserId());
        customer.setUser(user);
        customer.setActive(request.isActive());

        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerRepository.deleteById(id);
    }
}
