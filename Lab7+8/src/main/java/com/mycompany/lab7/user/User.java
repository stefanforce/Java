package com.mycompany.lab7.user;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name="users")
@NamedQueries({
        @NamedQuery(name = "User.getByEmail", query = "select us from User us where us.email = :email"),
        @NamedQuery(name = "User.getAll", query = "select us from User us")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="user_role")
    private String userRole;

    public User() {
    }

    public User(String email, String password, String userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
//
//    @Override
//    public String toString() {
//        return "com.mycompany.lab7.user.User1[ id=" + id + " ]";
//    }
    
}
