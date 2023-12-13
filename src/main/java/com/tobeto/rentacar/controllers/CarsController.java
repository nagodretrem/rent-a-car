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
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void create(@RequestBody Car car){
        carRepository.save(car);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Car car){
        Car updatedCar = carRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no car with id: " + id));
        updatedCar.setId(car.getId());
        updatedCar.setPlateNumber(car.getPlateNumber());
        updatedCar.setKilometer(car.getKilometer());
        updatedCar.setDailyPrice(car.getDailyPrice());
        updatedCar.setStatus(car.isStatus());
        updatedCar.setModel(car.getModel());
        updatedCar.setColor(car.getColor());

        carRepository.save(updatedCar);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);
    }

}
