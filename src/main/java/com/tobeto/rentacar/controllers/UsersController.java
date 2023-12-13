package com.tobeto.rentacar.controllers;

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
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("There is no user with id: " + id));
        updatedUser.setId(user.getId());
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        updatedUser.setNationalityNumber(user.getNationalityNumber());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setBirthDate(user.getBirthDate());

        userRepository.save(updatedUser);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

}
