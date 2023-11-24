package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.entities.PaymentMethod;
import com.tobeto.rentacar.repositories.PaymentMethodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment-methods")
public class PaymentMethodsController {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodsController(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @GetMapping
    public List<PaymentMethod> getAll() {

        return paymentMethodRepository.findAll();
    }

    @GetMapping("{id}")
    public PaymentMethod getById(@PathVariable int id)
    {
        return paymentMethodRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody PaymentMethod paymentMethod){
        paymentMethodRepository.save(paymentMethod);
    }

    @PutMapping
    public void update(@RequestBody PaymentMethod paymentMethod){
        paymentMethodRepository.findById(paymentMethod.getId()).orElseThrow();
        paymentMethodRepository.save(paymentMethod);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        paymentMethodRepository.deleteById(id);
    }
}
