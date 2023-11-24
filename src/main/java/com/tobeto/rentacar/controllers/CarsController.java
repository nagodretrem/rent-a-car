package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {

    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id)
    {
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car brand){
        carRepository.save(brand);
    }

    @PutMapping
    public void update(@RequestBody Car car){
        carRepository.findById(car.getId()).orElseThrow();
        carRepository.save(car);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);

        //aynı işi tek satırda yapan kod
        //carRepository.deleteById(id);
    }
 }
