package ar.com.soyseeb.rest.controllers;

import ar.com.soyseeb.core.services.RespuestaService;
import ar.com.soyseeb.rest.dto.PeriodoDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.*;

/**
 * Created by sbogado on 13/12/2016.
 */
@RestController
@RequestMapping("/admin/api/reporte_detallado")
public class ReporteDetalladoController {

    @Autowired
    private RespuestaService respuestaService;



    @RequestMapping(value = "/anual", method = RequestMethod.GET)
    public Collection<PeriodoDataDTO> getReporteDetalladoAnual(@RequestParam("year") Integer year){
        Date maxDate  = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(maxDate);
        maxDate = getMaxDateOfYear(year); // calendar.get(Calendar.YEAR) > year ? maxDate :
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
        List<PeriodoDataDTO> meses = new ArrayList<>();
        while(calendar.getTime().compareTo(maxDate) < 0 ){
            meses.add(getMonth(calendar.getTime()));
            calendar.add(Calendar.MONTH,1);
        }
        return meses;
    }



    @RequestMapping(value = "/semanal", method = RequestMethod.GET)
    public Collection<PeriodoDataDTO> getInformacionSemanal(@RequestParam(value = "from")@DateTimeFormat(pattern="dd-MM-yyyy") Date fechaDesde, @RequestParam(value = "to")@DateTimeFormat(pattern="dd-MM-yyyy") Date fechaHasta){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaDesde);
        List<PeriodoDataDTO> dias = new ArrayList<>();

        while(calendar.getTime().compareTo(fechaHasta) <= 0 ){
            if(calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                dias.add(getDay(calendar.getTime()));
            }
            calendar.add(Calendar.DAY_OF_WEEK,1);
        }
        return dias;
    }

    private PeriodoDataDTO getDay(Date time) {
        PeriodoDataDTO periodoDataDTO = new PeriodoDataDTO();
        String [] daysName= new DateFormatSymbols(new Locale("es","ES")).getWeekdays();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        periodoDataDTO.setPositivos(respuestaService.getRespuestasDelDiaPositivas(time));
        periodoDataDTO.setNegativos(respuestaService.getRespuestasDelDiaNegativas(time));
        periodoDataDTO.setPeriodo(daysName[calendar.get(Calendar.DAY_OF_WEEK)]);
        return periodoDataDTO;
    }


    public PeriodoDataDTO getMonth(Date fecha){
        PeriodoDataDTO periodoDataDTO = new PeriodoDataDTO();
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        periodoDataDTO.setPositivos(respuestaService.getRespuestasDelMesPositivas( localDate.getMonthValue() - 1, localDate.getYear() ) );
        periodoDataDTO.setNegativos(respuestaService.getRespuestasDelMesNegativos( localDate.getMonthValue() - 1, localDate.getYear() ) );
        periodoDataDTO.setPeriodo(localDate.getMonth().getDisplayName(TextStyle.FULL,new Locale("es","ES") ));
        return periodoDataDTO;
    }


    private Date getMaxDateOfYear(Integer year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }





}
