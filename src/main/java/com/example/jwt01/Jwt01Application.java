package com.example.jwt01;

import com.example.jwt01.model.Role;
import com.example.jwt01.model.User;
import com.example.jwt01.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Jwt01Application {

    public static void main(String[] args) {
        SpringApplication.run(Jwt01Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Vincent", "vincent", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "John", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Peter", "peter", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Dennis", "dennis", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_USER");
            userService.addRoleToUser("john", "ROLE_MANAGER");
            userService.addRoleToUser("vincent", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("vincent", "ROLE_ADMIN");
            userService.addRoleToUser("vincent", "ROLE_USER");
            userService.addRoleToUser("peter", "ROLE_ADMIN");
            userService.addRoleToUser("dennis", "ROLE_MANAGER");
        };
    }
}
