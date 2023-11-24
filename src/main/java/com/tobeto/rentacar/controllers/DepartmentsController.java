package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.entities.Department;
import com.tobeto.rentacar.repositories.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentsController {

    private final DepartmentRepository departmentRepository;

    public DepartmentsController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @GetMapping("{id}")
    public Department getById(@PathVariable int id)
    {
        return departmentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Department department){
        departmentRepository.save(department);
    }

    @PutMapping
    public void update(@RequestBody Department department){
        departmentRepository.findById(department.getId()).orElseThrow();
        departmentRepository.save(department);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        departmentRepository.deleteById(id);
    }

}
