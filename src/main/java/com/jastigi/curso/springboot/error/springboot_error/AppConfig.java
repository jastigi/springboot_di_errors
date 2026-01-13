package com.jastigi.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jastigi.curso.springboot.error.springboot_error.models.domain.Role;
import com.jastigi.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {

        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Jorge", "Martinez", new Role("ADMIN")));
        users.add(new User(2L, "Juan", "Perez", new Role("USER")));
        users.add(new User(3L, "Pedro", "Garcia", new Role("USER")));
        users.add(new User(4L, "Maria", "Lopez", new Role("USER")));
        users.add(new User(5L, "Ana", "Garcia", new Role(null)));

        return users;

    }

}
