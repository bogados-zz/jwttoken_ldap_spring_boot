package ar.com.soyseeb.core.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by sbogado on 30/01/2017.
 */
public class PreguntaNotExistException extends BussinessException {


    private static final String DEFAULT_MESSAGE = "No se ha encontrado la pregunta solicitada";

    public PreguntaNotExistException() {
        super(createError());
    }

    public PreguntaNotExistException(String customMessage) {
        super(createError(customMessage));
    }


    private static Error createError() {
        return createError(DEFAULT_MESSAGE);
    }

    private static Error createError(String message) {
        Error error = new Error();
        error.setMessage(message);
        error.setStatus(HttpStatus.NOT_FOUND);
        return error;
    }

    public PreguntaNotExistException(String message, Throwable cause) {
        super(message, cause, createError(message));
    }
}
