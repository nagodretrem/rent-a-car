package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.entities.InsuranceCoverage;
import com.tobeto.rentacar.repositories.InsuranceCoverageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/insurance-coverages")
public class InsuranceCoveragesController {

    private final InsuranceCoverageRepository insuranceCoverageRepository;


    public InsuranceCoveragesController(InsuranceCoverageRepository insuranceCoverageRepository) {
        this.insuranceCoverageRepository = insuranceCoverageRepository;
    }

    @GetMapping
    public List<InsuranceCoverage> getAll() {

        return insuranceCoverageRepository.findAll();
    }

    @GetMapping("{id}")
    public InsuranceCoverage getById(@PathVariable int id)
    {
        return insuranceCoverageRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody InsuranceCoverage insuranceCoverage){
        insuranceCoverageRepository.save(insuranceCoverage);
    }

    @PutMapping
    public void update(@RequestBody InsuranceCoverage insuranceCoverage){
        insuranceCoverageRepository.findById(insuranceCoverage.getId()).orElseThrow();
        insuranceCoverageRepository.save(insuranceCoverage);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        insuranceCoverageRepository.deleteById(id);
    }
}
