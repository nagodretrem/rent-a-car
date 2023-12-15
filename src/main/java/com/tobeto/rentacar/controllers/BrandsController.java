package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentacar.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacar.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentacar.dtos.responses.brand.GetBrandResponse;
import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
    private final BrandRepository brandRepository;

    public BrandsController(BrandRepository brandRepository) {

        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<GetBrandListResponse> getAll(){

        List<Brand> brands = brandRepository.findAll();

        return brands.stream().map(brand -> {
            GetBrandListResponse response = new GetBrandListResponse();
            response.setId(brand.getId());
            response.setName(brand.getName());
            return response;
        }).toList();


    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id) {

        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandResponse response = new GetBrandResponse();

        response.setName(brand.getName());

        return response;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request)
    {
        Brand brand = new Brand();
        brand.setName(request.getName());

        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest request){

        Brand brand = brandRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no brand with id: " + id));
        brand.setName(request.getName());

        brandRepository.save(brand);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brandRepository.deleteById(id);
    }


}
