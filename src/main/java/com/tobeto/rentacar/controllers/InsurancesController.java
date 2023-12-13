package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Insurance;
import com.tobeto.rentacar.repositories.InsuranceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/insurances")
public class InsurancesController {
    private final InsuranceRepository insuranceRepository;

    public InsurancesController(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @GetMapping
    public List<Insurance> getAll(){
        return insuranceRepository.findAll();
    }

    @GetMapping("{id}")
    public Insurance getById(@PathVariable int id){
        return insuranceRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void save(@RequestBody Insurance insurance){
        insuranceRepository.save(insurance);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Insurance insurance){
        Insurance updatedInsurance = insuranceRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no insurance with id: " + id));
        updatedInsurance.setId(insurance.getId());
        updatedInsurance.setCoverage(insurance.getCoverage());
        updatedInsurance.setDailyPrice(insurance.getDailyPrice());
        updatedInsurance.setStatus(insurance.isStatus());
        updatedInsurance.setInsuranceCompany(insurance.getInsuranceCompany());

        insuranceRepository.save(updatedInsurance);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        insuranceRepository.deleteById(id);
    }


}
