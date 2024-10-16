package com.ricardo.curso.springboot.error.springboot_error;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ricardo.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    public List<User> UserServiceImpl() {
        List<User> users = List.of(
            new User(1L, "Ricardo", "Cano"), 
            new User(2L, "jose", "Cano"), 
            new User(3L, "alex", "Cano"), 
            new User(4L, "nano", "Cano"),
            new User(5L, "luis", "Cano"));
            return users;
    }

}
