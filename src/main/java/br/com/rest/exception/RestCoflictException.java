/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rest.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author CaroleCristhian
 */
public class RestCoflictException extends RestException{
    {super.status = HttpStatus.CONFLICT;}
   
    

    public void setStatus(HttpStatus status) {
        
        this.status = status;
    }

    public RestCoflictException() {
       
    }

    public RestCoflictException(String message) {
        super(message);
    }

    public RestCoflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestCoflictException(Throwable cause) {
        super(cause);
    }

    public RestCoflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
