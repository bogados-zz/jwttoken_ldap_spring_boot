package ar.com.soyseeb.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by sbogado on 05/12/2016.
 */
@Entity
public class Pregunta {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(max=50)
    private String mensaje;

    @OneToMany(mappedBy="pregunta")
    private List<Respuesta> respuestas;

    private Boolean active;

    public Pregunta(){
        this.active=true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    @JsonIgnore
    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", mensaje='" + mensaje + '\'' +
                ", respuestas=" + respuestas +
                ", active=" + active +
                '}';
    }

    public void addRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
    }
}
