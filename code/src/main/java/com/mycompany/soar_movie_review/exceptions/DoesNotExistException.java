/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soar_movie_review.exceptions;

/**
 *
 * @author AlexBys
 */
public class DoesNotExistException extends Exception {
    private String message;
    
    public DoesNotExistException (String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
