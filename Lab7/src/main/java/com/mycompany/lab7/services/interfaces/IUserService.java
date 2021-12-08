package com.mycompany.lab7.services.interfaces;

import com.mycompany.lab7.user.User;

public interface IUserService {
    void add(String email, String password, String role);

    User login(String email, String password);
}
