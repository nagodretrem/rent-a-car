package com.tobeto.rentacar.controllers;

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
    public List<Model> getAll(){
        return modelRepository.findAll();
    }

    @GetMapping("{id}")
    public Model getById(@PathVariable int id) {
        return modelRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void save(@RequestBody Model model){
        modelRepository.save(model);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Model model){
        Model updatedModel = modelRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no model with id: " + id));
        updatedModel.setId(model.getId());
        updatedModel.setName(model.getName());

        modelRepository.save(updatedModel);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        modelRepository.deleteById(id);
    }

}
