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
public class RestNoContentException  extends RestException{
    {super.status = HttpStatus.NO_CONTENT;}

    public RestNoContentException() {
    }

    public RestNoContentException(String message) {
        super(message);
    }

    public RestNoContentException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestNoContentException(Throwable cause) {
        super(cause);
    }

    public RestNoContentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
