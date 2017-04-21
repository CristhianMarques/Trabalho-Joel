/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CaroleCristhian
 */
@RestController
@ControllerAdvice
public class GlobalHandLerException extends RestException{
 
    @ExceptionHandler(RestException.class)
    public ResponseEntity demoExceptionHandler(RestException ex){
       
      return  ResponseEntity 
                .status(ex.status)
                .body(ex.getMessage());
        
    }
}
