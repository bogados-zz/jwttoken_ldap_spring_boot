package ar.com.soyseeb.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sbogado on 05/12/2016.
 */

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fecha;
    private Boolean respuesta;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pregunta pregunta;

    public Respuesta(){
        this.fecha = new Date();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "id=" + id +
                ", palabraUnica='" + /*palabraUnica + '\'' +*/
                ", fecha=" + fecha +
                ", respuesta=" + respuesta +
                '}';
    }


}

