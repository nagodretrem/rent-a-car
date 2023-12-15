package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.insurancecompany.AddInsuranceCompanyRequest;
import com.tobeto.rentacar.dtos.requests.insurancecompany.UpdateInsuranceCompanyRequest;
import com.tobeto.rentacar.dtos.responses.insurancecompany.GetInsuranceCompanyListResponse;
import com.tobeto.rentacar.dtos.responses.insurancecompany.GetInsuranceCompanyResponse;
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
    public List<GetInsuranceCompanyListResponse> getAll(){

        List<InsuranceCompany> insuranceCompanies = insuranceCompanyRepository.findAll();

        return insuranceCompanies.stream().map(insuranceCompany -> {
            GetInsuranceCompanyListResponse response = new GetInsuranceCompanyListResponse();
            response.setId(insuranceCompany.getId());
            response.setName(insuranceCompany.getName());
            return response;
        }).toList();


    }


    @GetMapping("{id}")
    public GetInsuranceCompanyResponse getById(@PathVariable int id) {

        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no insurance company with id: " + id));
        GetInsuranceCompanyResponse response = new GetInsuranceCompanyResponse();

        response.setName(insuranceCompany.getName());
        return response;
    }


    @PostMapping
    public void add(@RequestBody AddInsuranceCompanyRequest request)
    {

        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setName(request.getName());

        insuranceCompanyRepository.save(insuranceCompany);

    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateInsuranceCompanyRequest request){

        InsuranceCompany insuranceCompany = insuranceCompanyRepository.findById(id).orElseThrow();
        insuranceCompany.setName(request.getName());

        insuranceCompanyRepository.save(insuranceCompany);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        insuranceCompanyRepository.deleteById(id);
    }


}
