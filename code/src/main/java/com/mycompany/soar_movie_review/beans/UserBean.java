/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soar_movie_review.beans;


import com.mycompany.soar_movie_review.exceptions.AlreadyExistsException;
import com.mycompany.soar_movie_review.exceptions.DoesNotExistException;
import com.mycompany.soar_movie_review.models.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.PersistenceContext;

/**
 *
 * @author simondemont
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
        @PersistenceContext(unitName = "prod")
    private EntityManager em;
   
    private String username = "";
    private String email = "";
    private String  password = "";

    @Transactional
    public void createAUser() {
        try {
            if (!emailExists() && !usernameExists()) {
                Users newUser = new Users ();
                newUser.setUsername (username);
                newUser.setEmail (email);
                newUser.setPassword(password.hashCode());
                em.persist(newUser);   
            }
            
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        // empty values
        this.username = "";
        this.email = "";
        this.password = "";
    }

//    protected static Users findByUsername(String username) throws DoesNotExistException {
//        for (Users user : Database.getInstance().getUsers()) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
//        throw new DoesNotExistException("The user " + username + " does not exist.");
//    }

    protected boolean emailExists() throws AlreadyExistsException {
      Query query = em.createNamedQuery("Users.findByEmail");
      List<Users> users = query.setParameter("email", email).getResultList();
      return users.size() > 0;
    }

    protected boolean usernameExists() throws DoesNotExistException {
      Query query = em.createNamedQuery("Users.findByUsername");
      List<Users> users = query.setParameter("username", username).getResultList();
      return users.size() > 0;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
