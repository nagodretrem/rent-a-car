package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.InsuranceCompany;
import com.tobeto.rentacar.repositories.InsuranceCompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/insuranceCompanies")
public class InsuranceCompaniesController {
    private final InsuranceCompanyRepository insuranceCompanyRepository;

    public InsuranceCompaniesController(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }


    @GetMapping
    public List<InsuranceCompany> getAll(){
        return insuranceCompanyRepository.findAll();
    }


    @GetMapping("{id}")
    public InsuranceCompany getById(@PathVariable int id) {
        return insuranceCompanyRepository.findById(id).orElseThrow();
    }


    @PostMapping
    public void save(@RequestBody InsuranceCompany insuranceCompany)
    {
        insuranceCompanyRepository.save(insuranceCompany);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody InsuranceCompany insuranceCompany){
        InsuranceCompany updatedInsuranceCompany = insuranceCompanyRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no insurance company with id: " + id));
        updatedInsuranceCompany.setId(insuranceCompany.getId());
        updatedInsuranceCompany.setName(insuranceCompany.getName());

        insuranceCompanyRepository.save(updatedInsuranceCompany);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        insuranceCompanyRepository.deleteById(id);
    }


}
