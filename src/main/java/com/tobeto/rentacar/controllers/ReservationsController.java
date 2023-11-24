package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.entities.Reservation;
import com.tobeto.rentacar.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationsController {

    private final ReservationRepository reservationRepository;


    public ReservationsController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @GetMapping("{id}")
    public Reservation getById(@PathVariable int id)
    {
        return reservationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
    }

    @PutMapping
    public void update(@RequestBody Reservation reservation){
        reservationRepository.findById(reservation.getId()).orElseThrow();
        reservationRepository.save(reservation);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        reservationRepository.deleteById(id);
    }
}
