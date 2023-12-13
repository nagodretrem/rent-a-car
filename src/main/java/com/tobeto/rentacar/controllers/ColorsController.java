package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Color;
import com.tobeto.rentacar.repositories.ColorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
    private final ColorRepository colorRepository;

    public ColorsController(ColorRepository colorRepository) {

        this.colorRepository = colorRepository;

    }


    @GetMapping
    public List<Color> getAll(){
        return colorRepository.findAll();
    }

    @GetMapping("{id}")
    public Color getById(@PathVariable int id) {
        return colorRepository.findById(id).orElseThrow();
    }


    @PostMapping
    public void save(@RequestBody Color color)
    {
        colorRepository.save(color);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Color color){
        Color updatedColor = colorRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no color with id: " + id));
        updatedColor.setId(color.getId());
        updatedColor.setName(color.getName());

        colorRepository.save(updatedColor);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        colorRepository.deleteById(id);
    }
}
