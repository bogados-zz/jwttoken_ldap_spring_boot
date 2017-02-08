package ar.com.soyseeb.core.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

/**
 * Created by sbogado on 16/12/2016.
 */
public class Error {

    private String message;
    @JsonIgnore
    private HttpStatus status;

    public Error() {
    }

    public Error(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public Error(String message) {
        this.message = message;
        this.status=HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
