package ar.com.soyseeb.rest.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * Created by sbogado on 07/12/2016.
 */
public class PeriodoDataDTO {

    private String periodo;
    private Long positivos;
    private Long negativos;


    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Long getPositivos() {
        return positivos;
    }

    public void setPositivos(Long positivos) {
        this.positivos = positivos;
    }

    public Long getNegativos() {
        return negativos;
    }

    public void setNegativos(Long negativos) {
        this.negativos = negativos;
    }


    @JsonGetter(value = "total")
    public Long getTotal(){
        return this.positivos+ this.negativos;
    }

}
