package com.mycompany.lab7.repositories.interfaces;

import com.mycompany.lab7.user.User;

public interface IUserRepository extends IRepository<User> {
       
    User getByEmail(String username);
}
