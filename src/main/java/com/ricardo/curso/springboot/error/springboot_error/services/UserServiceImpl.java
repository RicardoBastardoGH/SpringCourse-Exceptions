package com.ricardo.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;
    // public UserServiceImpl() {
    //     this.users = List.of(
    //         new User(1L, "Ricardo", "Cano"), 
    //         new User(2L, "jose", "Cano"), 
    //         new User(3L, "alex", "Cano"), 
    //         new User(4L, "nano", "Cano"),
    //         new User(5L, "luis", "Cano"));
    // }

    @Override
    public List<User> findAll() {

        return users;
    }
    
    @Override
    public Optional<User> findById(Long id) {
       return users.stream().filter( usr -> usr.getId().equals(id)).findFirst();
        // for (User u : users) {
        //     if (u.getId().equals(id)) {
        //         user = u;
        //         System.out.println("User found: " + user);
        //         break;
        //     }
        // }
        // return user;
        
    }

}
