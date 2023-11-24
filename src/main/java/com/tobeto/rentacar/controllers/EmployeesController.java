package com.tobeto.rentacar.controllers;


import com.tobeto.rentacar.entities.Employee;
import com.tobeto.rentacar.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id)
    {
        return employeeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee){
        employeeRepository.findById(employee.getId()).orElseThrow();
        employeeRepository.save(employee);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        employeeRepository.deleteById(id);
    }
}
