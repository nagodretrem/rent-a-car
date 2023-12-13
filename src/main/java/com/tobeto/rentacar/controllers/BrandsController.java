package com.tobeto.rentacar.controllers;

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
    public List<Brand> getAll(){

        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id) {
        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void save(@RequestBody Brand brand)
    {
        brandRepository.save(brand);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Brand brand){
        Brand updatedBrand = brandRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no brand with id: " + id));
        updatedBrand.setId(brand.getId());
        updatedBrand.setName(brand.getName());

        brandRepository.save(updatedBrand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        brandRepository.deleteById(id);
    }


}
