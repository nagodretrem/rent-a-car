package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.insurance.AddInsuranceRequest;
import com.tobeto.rentacar.dtos.requests.insurance.UpdateInsuranceRequest;
import com.tobeto.rentacar.dtos.responses.insurance.GetInsuranceListResponse;
import com.tobeto.rentacar.dtos.responses.insurance.GetInsuranceResponse;
import com.tobeto.rentacar.entities.Insurance;
import com.tobeto.rentacar.entities.InsuranceCompany;
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
    public List<GetInsuranceListResponse> getAll(){

        List<Insurance> insurances = insuranceRepository.findAll();

        return insurances.stream().map(insurance -> {
            GetInsuranceListResponse response = new GetInsuranceListResponse();
            response.setId(insurance.getId());
            response.setCoverage(insurance.getCoverage());
            response.setDailyPrice(insurance.getDailyPrice());
            response.setActive(insurance.isActive());
            response.setCompanyName(insurance.getInsuranceCompany().getName());
            return response;
        }).toList();

    }

    @GetMapping("{id}")
    public GetInsuranceResponse getById(@PathVariable int id){

        Insurance insurance = insuranceRepository.findById(id).orElseThrow();
        GetInsuranceResponse response = new GetInsuranceResponse();
        response.setCompanyName(insurance.getInsuranceCompany().getName());
        response.setCoverage(insurance.getCoverage());
        response.setDailyPrice(insurance.getDailyPrice());
        response.setActive(insurance.isActive());
        return response;

    }

    @PostMapping
    public void add(@RequestBody AddInsuranceRequest request){

        Insurance insurance = new Insurance();
        insurance.setCoverage(request.getCoverage());
        insurance.setDailyPrice(request.getDailyPrice());

        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setId(request.getCompanyId());
        insurance.setInsuranceCompany(insuranceCompany);

        insuranceRepository.save(insurance);


    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateInsuranceRequest request){

        Insurance insurance = insuranceRepository.findById(id).orElseThrow();

        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setId(request.getCompanyId());
        insurance.setInsuranceCompany(insuranceCompany);

        insurance.setCoverage(request.getCoverage());
        insurance.setDailyPrice(request.getDailyPrice());
        insurance.setActive(request.isActive());

        insuranceRepository.save(insurance);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        insuranceRepository.deleteById(id);
    }


}
