package com.example.sistemaalumnos.demo.controller;

import com.example.sistemaalumnos.demo.model.User;
import com.example.sistemaalumnos.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getUser(){
        return  userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping("")
    public void newUser(@Valid @RequestBody User user){
        userService.newUser(user);
    }

    @PutMapping("")
    public void editUser(@Valid @RequestBody User user){
        userService.editUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

}
