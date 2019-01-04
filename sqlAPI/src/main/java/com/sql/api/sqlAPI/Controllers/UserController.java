package com.sql.api.sqlAPI.Controllers;


import com.sql.api.sqlAPI.Models.User;
import com.sql.api.sqlAPI.Models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {


    @GetMapping("/user")
    @ResponseBody
    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public Optional<User> getUserById(@PathVariable long id){
        Optional<User> user=userDao.findById(id);
        return user;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
       User savedUser = userDao.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }


    @Autowired
    private UserDao userDao;

}
