package com.mycompany.lab7.managedBeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import com.mycompany.lab7.user.User;
import com.mycompany.lab7.repositories.interfaces.IUserRepository;
import com.mycompany.lab7.services.interfaces.IUserService;

/**
 *
 * @author Andrei
 */
@RequestScoped
@Named("userBean")
public class UserBean {

    private IUserService userService;

    @Inject
    IUserRepository userRepository;

    @Inject
    Pbkdf2PasswordHash passwordHasher;

    private String email;
    private String password;
    private String passwordConfirm;
    private String userRole = "student";

    public String addUser() {
        if(checkUserExists()) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "User already exists"));
            return null;
        }
        if (!checkPasswordMatch()) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Password doesn't match"));
            return null;
        } else {
            User user = new User(email, passwordHasher.generate(password.toCharArray()), userRole);
            userRepository.create(user);
            return "authenticate";
        }
    }

    public void loginUser() {
        User user = userService.login(email, password);
    }

    public boolean checkPasswordMatch() {
        return password.equals(passwordConfirm);
    }
    
    public boolean checkUserExists() {
        return userRepository.getByEmail(email) != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

}
