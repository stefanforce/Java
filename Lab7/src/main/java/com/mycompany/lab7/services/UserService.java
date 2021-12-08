package com.mycompany.lab7.services;

import javax.inject.Inject;
import com.mycompany.lab7.user.User;
import com.mycompany.lab7.repositories.UserRepository;
import com.mycompany.lab7.repositories.interfaces.IUserRepository;
import com.mycompany.lab7.services.interfaces.IUserService;
import java.time.LocalTime;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserService implements IUserService {

    @Inject
    private IUserRepository userRepository;

    @Override
    public void add(String email, String password, String role) {
        System.out.println(".....Method called.......");
        LocalTime targetTime = LocalTime.now();
        Boolean ok= (targetTime.isAfter(LocalTime.parse("12:00:00"))
                &&targetTime.isBefore(LocalTime.parse("24:00:00")));
        if(ok){
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(email, hashedPassword, role);
        userRepository.create(user);}
    }

    @Override
    public User login(String email, String password) {
        User userByUsername = userRepository.getByEmail(email);

        if (userByUsername != null) {
            if (BCrypt.checkpw(password, userByUsername.getPassword())) {
                return userByUsername;
            }
        }

        return null;
    }
}
