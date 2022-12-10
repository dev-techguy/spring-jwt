package com.example.jwt01.service;

import com.example.jwt01.model.Role;
import com.example.jwt01.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
