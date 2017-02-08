package ar.com.soyseeb.core.exceptions;

/**
 * Created by sbogado on 19/12/2016.
 */
//TODO define the class
public class WrongPasswordException extends BussinessException {
    public WrongPasswordException(Error error) {
        super(error);
    }

    public WrongPasswordException(String message, Throwable cause, Error error) {
        super(message, cause, error);
    }

}
