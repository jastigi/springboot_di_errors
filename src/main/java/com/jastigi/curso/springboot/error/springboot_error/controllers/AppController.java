package com.jastigi.curso.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jastigi.curso.springboot.error.springboot_error.exceptions.UserNotFoudException;
import com.jastigi.curso.springboot.error.springboot_error.models.domain.User;
import com.jastigi.curso.springboot.error.springboot_error.services.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("10x");
        System.out.println("Valor: " + value);
        return "Ok 200";
    }

    @GetMapping("/user/{id}")
    public User userDetail(@PathVariable Long id) {
        User user = service.findById(id)
                .orElseThrow(() -> new UserNotFoudException("El usuario con id " + id + " no existe"));
        System.out.println(user.getName());
        return user;
    }

}
