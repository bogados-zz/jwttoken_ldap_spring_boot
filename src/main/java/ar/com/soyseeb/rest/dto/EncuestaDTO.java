package ar.com.soyseeb.rest.dto;

import ar.com.soyseeb.core.model.Pregunta;
import ar.com.soyseeb.core.model.Respuesta;

/**
 * Created by sbogado on 07/02/2017.
 */
public class EncuestaDTO {
    private Pregunta pregunta;
    private Respuesta respuesta;
    private String message;

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
