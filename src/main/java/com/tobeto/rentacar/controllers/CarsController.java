package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.car.AddCarRequest;
import com.tobeto.rentacar.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacar.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentacar.dtos.responses.car.GetCarResponse;
import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.entities.Color;
import com.tobeto.rentacar.entities.Model;
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
    public List<GetCarListResponse> getAll(){

        List<Car> cars = carRepository.findAll();

        return cars.stream().map(car -> {
            GetCarListResponse response = new GetCarListResponse();
            response.setId(car.getId());
            response.setPlateNumber(car.getPlateNumber());
            response.setKilometer(car.getKilometer());
            response.setDailyPrice(car.getDailyPrice());
            response.setIsActive(car.isActive());
            return response;
        }).toList();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {

        Car car = carRepository.findById(id).orElseThrow();
        GetCarResponse response = new GetCarResponse();

        response.setPlateNumber(car.getPlateNumber());
        response.setKilometer(car.getKilometer());
        response.setDailyPrice(car.getDailyPrice());
        response.setIsActive(car.isActive());

        return response;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request){

        Car car = new Car();



        car.setPlateNumber(request.getPlateNumber());
        car.setKilometer(request.getKilometer());
        car.setDailyPrice(request.getDailyPrice());

        Model model = new Model();
        model.setId(request.getModelId());
        car.setModel(model);

        Color color = new Color();
        color.setId(request.getColorId());
        car.setColor(color);


        carRepository.save(car);

    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest request){

        Car car = carRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no car with id: " + id));
        car.setPlateNumber(request.getPlateNumber());
        car.setKilometer(request.getKilometer());
        car.setDailyPrice(request.getDailyPrice());

        Model model = new Model();
        model.setId(request.getModelId());
        car.setModel(model);

        Color color = new Color();
        color.setId(request.getColorId());
        car.setColor(color);

        car.setActive(request.isActive());

        carRepository.save(car);


    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);
    }

}
