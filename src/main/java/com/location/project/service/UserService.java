package com.location.project.service;

import com.location.project.entity.User;

public interface UserService {
    void saveUser(User user);
    User findByUsername(String username);
}
