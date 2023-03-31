package com.evaluacion.exception;

/**
 *
 * @author Reyes
 */
public class ModelNotFoundException extends RuntimeException{
    
     public ModelNotFoundException(String message){
        super(message);
    }
}
