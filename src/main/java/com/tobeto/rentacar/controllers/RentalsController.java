package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.dtos.requests.rental.AddRentalRequest;
import com.tobeto.rentacar.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.rentacar.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.rentacar.dtos.responses.rental.GetRentalResponse;
import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final InsuranceRepository insuranceRepository;

    public RentalsController(RentalRepository rentalRepository, CarRepository carRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository, InsuranceRepository insuranceRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.insuranceRepository = insuranceRepository;

        this.rentalRepository = rentalRepository;


    }

    @GetMapping
    public List<GetRentalListResponse> getAll(){

        List<Rental> rentals = rentalRepository.findAll();

        return rentals.stream().map(rental -> {
            GetRentalListResponse response = new GetRentalListResponse();
            response.setId(rental.getId());
            response.setStartDate(rental.getStartDate());
            response.setEndDate(rental.getEndDate());
            response.setCarModel(rental.getCar().getModel().getName());
            response.setCustomerName(rental.getCustomer().getUser().getFirstname() + " " + rental.getCustomer().getUser().getLastname());
            response.setEmployeeName(rental.getEmployee().getUser().getFirstname() + " " + rental.getEmployee().getUser().getLastname());
            response.setTotalPrice(rental.getTotalPrice());
            return response;
        }).toList();



    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id) {

        Rental rental = rentalRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no rental with id: " + id));

        GetRentalResponse response = new GetRentalResponse();

        response.setCarModel(rental.getCar().getModel().getName());
        response.setCustomerName(rental.getCustomer().getUser().getFirstname() + " " + rental.getCustomer().getUser().getLastname());
        response.setEmployeeName(rental.getEmployee().getUser().getFirstname() + " " + rental.getEmployee().getUser().getLastname());
        response.setStartDate(rental.getStartDate());
        response.setEndDate(rental.getEndDate());
        response.setTotalPrice(rental.getTotalPrice());
        response.setDiscount(rental.getDiscount());

        return response;

    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest request){

        Rental rental = new Rental();
        rental.setStartDate(request.getStartDate());
        rental.setEndDate(request.getEndDate());
        rental.setStartKilometer(request.getStartKilometer());

        rental.setTotalPrice(request.getTotalPrice());
        rental.setDiscount(request.getDiscount());

        rental.setCar(carRepository.findById(request.getCarId()).orElseThrow(()-> new RuntimeException("There is no car with id: " + request.getCarId())));
        rental.setCustomer(customerRepository.findById(request.getCustomerId()).orElseThrow(()-> new RuntimeException("There is no customer with id: " + request.getCustomerId())));
        rental.setEmployee(employeeRepository.findById(request.getEmployeeId()).orElseThrow(()-> new RuntimeException("There is no employee with id: " + request.getEmployeeId())));
        rental.setInsurance(insuranceRepository.findById(request.getInsuranceId()).orElseThrow(()-> new RuntimeException("There is no insurance with id: " + request.getInsuranceId())));

        rentalRepository.save(rental);


    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateRentalRequest request){

        Rental rental = rentalRepository.findById(id).orElseThrow();
        rental.setStartDate(request.getStartDate());
        rental.setEndDate(request.getEndDate());
        rental.setStartKilometer(request.getStartKilometer());

        rental.setTotalPrice(request.getTotalPrice());
        rental.setDiscount(request.getDiscount());

        rental.setCar(carRepository.findById(request.getCarId()).orElseThrow(()-> new RuntimeException("There is no car with id: " + request.getCarId())));
        rental.setCustomer(customerRepository.findById(request.getCustomerId()).orElseThrow(()-> new RuntimeException("There is no customer with id: " + request.getCustomerId())));
        rental.setEmployee(employeeRepository.findById(request.getEmployeeId()).orElseThrow(()-> new RuntimeException("There is no employee with id: " + request.getEmployeeId())));
        rental.setInsurance(insuranceRepository.findById(request.getInsuranceId()).orElseThrow(()-> new RuntimeException("There is no insurance with id: " + request.getInsuranceId())));

        rentalRepository.save(rental);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalRepository.deleteById(id);
    }
}
