package ar.com.soyseeb.core.exceptions;

/**
 * Created by sbogado on 19/12/2016.
 */
public class BussinessException extends Exception {

    private Error error;


    public BussinessException(Error error) {
        this.error = error;
    }


    public BussinessException(String message, Throwable cause, Error error) {
        super(message, cause);
        this.error = error;
    }


    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
