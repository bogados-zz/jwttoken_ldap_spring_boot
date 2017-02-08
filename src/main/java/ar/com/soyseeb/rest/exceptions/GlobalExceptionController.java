package ar.com.soyseeb.rest.exceptions;

import ar.com.soyseeb.core.exceptions.BussinessException;
import ar.com.soyseeb.core.exceptions.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by sbogado on 16/12/2016.
 */


@RestControllerAdvice(basePackages = "ar.com.tssa")
public class GlobalExceptionController {


    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Error> securityExceptionHandler(){
        Error  error = new Error();
        error.setMessage("No tiene permisos ni credenciales necesarias para acceder al sitio");
        error.setStatus(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<Error>(error, error.getStatus());
    }

    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Error> resolveBusinessException(BussinessException ex) {
        return new ResponseEntity<Error>(ex.getError(), ex.getError().getStatus());
    }




}
