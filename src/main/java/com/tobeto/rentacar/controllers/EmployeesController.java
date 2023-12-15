package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.rentacar.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.rentacar.dtos.responses.employee.GetEmployeeListResponse;
import com.tobeto.rentacar.dtos.responses.employee.GetEmployeeResponse;
import com.tobeto.rentacar.entities.Employee;
import com.tobeto.rentacar.entities.User;
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
    public List<GetEmployeeListResponse> getAll(){

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> {
            GetEmployeeListResponse response = new GetEmployeeListResponse();
            response.setId(employee.getId());
            response.setName(employee.getUser().getFirstname() + " " + employee.getUser().getLastname());
            response.setTitle(employee.getTitle());
            response.setActive(employee.isActive());
            return response;
        }).toList();

    }

    @GetMapping("{id}")
    public GetEmployeeResponse getById(@PathVariable int id) {

        Employee employee = employeeRepository.findById(id).orElseThrow();
        GetEmployeeResponse response = new GetEmployeeResponse();

        response.setName(employee.getUser().getFirstname() + " " + employee.getUser().getLastname());
        response.setTitle(employee.getTitle());
        response.setActive(employee.isActive());

        return response;

    }

    @PostMapping
    public void add(@RequestBody AddEmployeeRequest request){



        Employee employee = new Employee();
        employee.setTitle(request.getTitle());
        employee.setSalary(request.getSalary());

        User user = new User();
        user.setId(request.getUserId());
        employee.setUser(user);

        employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateEmployeeRequest request){

        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setTitle(request.getTitle());
        employee.setSalary(request.getSalary());

        User user = new User();
        user.setId(request.getUserId());
        employee.setUser(user);

        employee.setActive(request.isActive());

        employeeRepository.save(employee);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        employeeRepository.deleteById(id);
    }
}
