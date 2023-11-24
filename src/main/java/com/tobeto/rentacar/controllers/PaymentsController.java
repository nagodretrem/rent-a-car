package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.entities.Payment;
import com.tobeto.rentacar.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {

    private final PaymentRepository paymentRepository;

    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAll() {

        return paymentRepository.findAll();
    }

    @GetMapping("{id}")
    public Payment getById(@PathVariable int id)
    {
        return paymentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentRepository.save(payment);
    }

    @PutMapping
    public void update(@RequestBody Payment payment){
        paymentRepository.findById(payment.getId()).orElseThrow();
        paymentRepository.save(payment);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        paymentRepository.deleteById(id);
    }
}
