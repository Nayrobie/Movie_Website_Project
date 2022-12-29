/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soar_movie_review.beans;

import com.mycompany.soar_movie_review.exceptions.DoesNotExistException;
import com.mycompany.soar_movie_review.models.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;

/**
 *
 * @author simondemont
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @PersistenceContext(unitName = "prod")
    private EntityManager em;

    private String username = "";
    private String password = "";
    private static Users currentUser;

    public String userLogsIn() {
        try {
            Users user = findByUsername();
            if (user != null && user.isPasswordCorrect(password)) {
                currentUser = user;
                return "/MovieUserPage/SeeMovieCatalogue.xhtml?faces-redirect=true";
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MovieHomePage/LoginPage.xhtml?faces-redirect=true";
    }

    protected Users findByUsername() throws DoesNotExistException {
        Query query = em.createNamedQuery("Users.findByUsername", Users.class);
        List<Users> users = query.setParameter("username", username).getResultList();
        if (users.size() > 0) {
            return users.get(0);
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }

    public String userLogsout() {
        currentUser = null;
        return "/MovieHomePage/Main.xhtml?faces-redirect=true";
    }

    public Users getCurrentUser() {
        return currentUser;
    }

    public static Users getUserLoggedIn() {
        return currentUser;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
