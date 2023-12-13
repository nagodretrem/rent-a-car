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
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void save(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Employee employee){
        Employee updatedEmployee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no employee with id: " + id));
        updatedEmployee.setId(employee.getId());
        updatedEmployee.setTitle(employee.getTitle());
        updatedEmployee.setSalary(employee.getSalary());
        updatedEmployee.setStatus(employee.isStatus());

        employeeRepository.save(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        employeeRepository.deleteById(id);
    }
}
