package ar.com.soyseeb.core.exceptions;

/**
 * Created by sbogado on 19/12/2016.
 */

//TODO define the class
public class UserNotExistException extends BussinessException {
    public UserNotExistException(Error error) {
        super(error);
    }

    public UserNotExistException(String message, Throwable cause, Error error) {
        super(message, cause, error);
    }
}
