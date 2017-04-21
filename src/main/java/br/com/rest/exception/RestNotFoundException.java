/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rest.exception;

import org.springframework.http.HttpStatus;
import static org.springframework.http.ResponseEntity.status;

/**
 *
 * @author CaroleCristhian
 */
public class RestNotFoundException extends RestException{
    
    {super.status = HttpStatus.NOT_FOUND;}

    public RestNotFoundException() {
      
    }

    public RestNotFoundException(String message) {
        super(message);
        
    }

    public RestNotFoundException(String message, Throwable cause) {
        super(message, cause);
       
    }

    public RestNotFoundException(Throwable cause) {
        super(cause);
        
    }

    public RestNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
       
    }
    
}
