package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping
    public List<Rental> getAll(){
        return rentalRepository.findAll();
    }

    @GetMapping("{id}")
    public Rental getById(@PathVariable int id) {
        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void save(@RequestBody Rental rental){
        rentalRepository.save(rental);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Rental rental){
        Rental updatedRental = rentalRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no rental with id: " + id));
        updatedRental.setId(rental.getId());
        updatedRental.setStartDate(rental.getStartDate());
        updatedRental.setEndDate(rental.getEndDate());
        updatedRental.setReturnDate(rental.getReturnDate());
        updatedRental.setStartKilometer(rental.getStartKilometer());
        updatedRental.setEndKilometer(rental.getEndKilometer());
        updatedRental.setTotalPrice(rental.getTotalPrice());
        updatedRental.setDiscount(rental.getDiscount());
        updatedRental.setCar(rental.getCar());
        updatedRental.setCustomer(rental.getCustomer());
        updatedRental.setEmployee(rental.getEmployee());

        rentalRepository.save(updatedRental);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalRepository.deleteById(id);
    }
}
