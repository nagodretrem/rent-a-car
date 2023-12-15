package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.color.AddColorRequest;
import com.tobeto.rentacar.dtos.requests.color.UpdateColorRequest;

import com.tobeto.rentacar.dtos.responses.color.GetColorListResponse;
import com.tobeto.rentacar.dtos.responses.color.GetColorResponse;
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
    public List<GetColorListResponse> getAll(){

        List<Color> colors = colorRepository.findAll();

        return colors.stream().map(color -> {
            GetColorListResponse response = new GetColorListResponse();
            response.setId(color.getId());
            response.setName(color.getName());
            return response;
        }).toList();

    }

    @GetMapping("{id}")
    public GetColorResponse getById(@PathVariable int id) {


        Color color = colorRepository.findById(id).orElseThrow();
        GetColorResponse response = new GetColorResponse();

        response.setName(color.getName());

        return response;
    }


    @PostMapping
    public void add(@RequestBody AddColorRequest request)
    {

        Color color = new Color();
        color.setName(request.getName());

        colorRepository.save(color);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateColorRequest request){

        Color color = colorRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no color with id: " + id));
        color.setName(request.getName());

        colorRepository.save(color);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        colorRepository.deleteById(id);
    }
}
