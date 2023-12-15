package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.model.AddModelRequest;
import com.tobeto.rentacar.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacar.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentacar.dtos.responses.model.GetModelResponse;
import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.entities.Model;
import com.tobeto.rentacar.repositories.ModelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
public class ModelsController {

    private final ModelRepository modelRepository;

    public ModelsController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @GetMapping
    public List<GetModelListResponse> getAll(){


        List<Model> models = modelRepository.findAll();

        return models.stream().map(model -> {
            GetModelListResponse response = new GetModelListResponse();
            response.setId(model.getId());
            response.setName(model.getName());
            return response;
        }).toList();
    }

    @GetMapping("{id}")
    public GetModelResponse getById(@PathVariable int id) {


        Model model = modelRepository.findById(id).orElseThrow();
        GetModelResponse response = new GetModelResponse();

        response.setName(model.getName());

        return response;
    }

    @PostMapping
    public void add(@RequestBody AddModelRequest request){

        Model model = new Model();
        model.setName(request.getName());

        Brand brand = new Brand();
        brand.setId(request.getBrandId());
        model.setBrand(brand);

        modelRepository.save(model);


    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateModelRequest request){

        Model model = modelRepository.findById(id).orElseThrow();
        model.setName(request.getName());

        Brand brand = new Brand();
        brand.setId(request.getBrandId());
        model.setBrand(brand);

        modelRepository.save(model);


    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        modelRepository.deleteById(id);
    }

}
