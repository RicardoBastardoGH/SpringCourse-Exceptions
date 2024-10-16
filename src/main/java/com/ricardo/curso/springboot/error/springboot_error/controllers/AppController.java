package com.ricardo.curso.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ricardo.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.ricardo.curso.springboot.error.springboot_error.models.domain.User;
import com.ricardo.curso.springboot.error.springboot_error.services.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index() {

        // int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario no existe"));
        
        // Optional<User> optionalUser = userService.findById(id);
        // if (optionalUser.isEmpty()) {
        //     return ResponseEntity.notFound().build();
        // }
        // System.out.println(optionalUser.getLastName());
        // return ResponseEntity.ok(optionalUser.orElseThrow());
        // return new User(1L, "Ricardo", "Carrion");

        return user;
    }
}
