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
public class AlreadyExistsException extends Exception {
    
    private String message;
    
    public AlreadyExistsException (String message) {
        this.message = message;
        
    }
    
    public String GetMessage() {
        return message;
    }
}
