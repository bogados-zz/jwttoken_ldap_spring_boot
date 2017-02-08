package ar.com.soyseeb.rest.controllers;

import ar.com.soyseeb.core.services.RespuestaService;
import ar.com.soyseeb.rest.dto.PeriodoDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sbogado on 07/12/2016.
 */
@RestController
@RequestMapping("/admin/api/reportes")
public class ReporteController {


    @Autowired
    private RespuestaService respuestaService;

    @RequestMapping(value="/diario", method = RequestMethod.GET)
    public PeriodoDataDTO getInformacionDiaria(@RequestParam(value = "date")@DateTimeFormat(pattern="dd-MM-yyyy") Date fecha){
        PeriodoDataDTO periodoDataDTO = new PeriodoDataDTO();
        periodoDataDTO.setPositivos(respuestaService.getRespuestasDelDiaPositivas(fecha));
        periodoDataDTO.setNegativos(respuestaService.getRespuestasDelDiaNegativas(fecha));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        periodoDataDTO.setPeriodo(sdf.format(fecha));
        return periodoDataDTO;
    }

    @RequestMapping(value="/mensual", method = RequestMethod.GET)
    public PeriodoDataDTO getInformacionMensual(@RequestParam("month") Integer month, @RequestParam("year") Integer year ){
        PeriodoDataDTO periodoDataDTO = new PeriodoDataDTO();
        periodoDataDTO.setPositivos(respuestaService.getRespuestasDelMesPositivas(month-1 , year));
        periodoDataDTO.setNegativos(respuestaService.getRespuestasDelMesNegativos(month-1, year));
        periodoDataDTO.setPeriodo("Mes "+month);
        return periodoDataDTO;
    }

    @RequestMapping(value="/anual" , method = RequestMethod.GET)
    public PeriodoDataDTO getInformacionAnual(@RequestParam("year") Integer year){
        PeriodoDataDTO periodoDataDTO = new PeriodoDataDTO();
        periodoDataDTO.setPositivos(respuestaService.getRespuestasDelAnioPositivas(year));
        periodoDataDTO.setNegativos(respuestaService.getRespuestasDelAnioNegativas(year));
        periodoDataDTO.setPeriodo("Año: " + year);
        return periodoDataDTO;
    }

    @RequestMapping(value="/filter", method = RequestMethod.GET)
    public PeriodoDataDTO getInformacionSemanal(@RequestParam(value = "fechaDesde")@DateTimeFormat(pattern="dd-MM-yyyy") Date fechaDesde, @RequestParam(value = "fechaHasta")@DateTimeFormat(pattern="dd-MM-yyyy") Date fechaHasta){
        PeriodoDataDTO periodoDataDTO = new PeriodoDataDTO();
        periodoDataDTO.setPositivos(respuestaService.getRespuestasDelPeriodoPositivas(fechaDesde, fechaHasta));
        periodoDataDTO.setNegativos(respuestaService.getRespuestasDelPeriodoNegativas(fechaDesde, fechaHasta));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        periodoDataDTO.setPeriodo(sdf.format(fechaDesde)+" a "+sdf.format(fechaHasta));
        return periodoDataDTO;
    }

    @RequestMapping(value="/today", method = RequestMethod.GET)
    public PeriodoDataDTO getInformacionToday(){
        PeriodoDataDTO periodoDataDTO = new PeriodoDataDTO();
        Date fecha = new Date();
        periodoDataDTO.setPositivos(respuestaService.getRespuestasDelDiaPositivas(fecha));
        periodoDataDTO.setNegativos(respuestaService.getRespuestasDelDiaNegativas(fecha));
        periodoDataDTO.setPeriodo(fecha.toString());
        return periodoDataDTO;
    }

}
