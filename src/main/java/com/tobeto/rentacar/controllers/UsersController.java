package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.dtos.requests.user.AddUserRequest;
import com.tobeto.rentacar.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacar.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentacar.dtos.responses.user.GetUserResponse;
import com.tobeto.rentacar.entities.User;
import com.tobeto.rentacar.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<GetUserListResponse> getAll(){

        List<User> users = userRepository.findAll();

        return users.stream().map(user -> {
            GetUserListResponse response = new GetUserListResponse();
            response.setId(user.getId());
            response.setFirstname(user.getFirstname());
            response.setLastname(user.getLastname());
            response.setEmail(user.getEmail());
            return response;
        }).toList();

    }

    @GetMapping("{id}")
    public GetUserResponse getById(@PathVariable int id) {

        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no user with id: " + id));

        GetUserResponse response = new GetUserResponse();

        response.setFirstName(user.getFirstname());
        response.setLastName(user.getLastname());
        response.setEmail(user.getEmail());

        return response;

    }

    @PostMapping
    public void add(@RequestBody AddUserRequest request){

        User user = new User();
        user.setFirstname(request.getFirstName());
        user.setLastname(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setNationalityNumber(request.getNationalityNumber());
        user.setAddress(request.getAddress());
        user.setBirthDate(request.getBirthDate());

        userRepository.save(user);

    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateUserRequest request){

        User user = userRepository.findById(id).orElseThrow();
        user.setFirstname(request.getFirstName());
        user.setLastname(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setNationalityNumber(request.getNationalityNumber());
        user.setAddress(request.getAddress());
        user.setBirthDate(request.getBirthDate());

        userRepository.save(user);



    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

}
