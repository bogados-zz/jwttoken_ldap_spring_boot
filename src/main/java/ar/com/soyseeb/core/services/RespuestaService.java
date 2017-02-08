package ar.com.soyseeb.core.services;

import ar.com.soyseeb.core.dao.RespuestaDao;
import ar.com.soyseeb.core.model.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sbogado on 06/12/2016.
 */
@Service
public class RespuestaService {

    @Autowired
    private RespuestaDao respuestaDao;

/*    @Autowired
    private CustomRespuestaDao customRespuestaDao;*/

    public Respuesta save(Respuesta respuesta){
        return respuestaDao.save(respuesta);
    }


    public Long getRespuestasDelPeriodoPositivas(Date fechaDesde, Date fechaHasta){
        return respuestaDao.countByFechaAndRespuesta(getFirstTime(fechaDesde), getLastTime(fechaHasta), true);
    }
    public Long getRespuestasDelPeriodoNegativas(Date fechaDesde, Date fechaHasta){
        return respuestaDao.countByFechaAndRespuesta(getFirstTime(fechaDesde), getLastTime(fechaHasta), false);
    }

    public Long getRespuestasDelDiaPositivas(Date fecha) {
        return respuestaDao.countByFechaAndRespuesta(getFirstTime(fecha),getLastTime(fecha),true);
    }

    public Long getRespuestasDelDiaNegativas(Date fecha) {
        return respuestaDao.countByFechaAndRespuesta(getFirstTime(fecha),getLastTime(fecha),false);
    }

    public Long getRespuestasDelMesPositivas(Integer month, Integer year){
        return respuestaDao.countByFechaAndRespuesta(getFirstTimeMonth(month,year), getLastTimeMonth(month,year), true);
    }

    public Long getRespuestasDelMesNegativos(Integer month, Integer year) {
        return respuestaDao.countByFechaAndRespuesta(getFirstTimeMonth(month,year), getLastTimeMonth(month,year), false);
    }

    public Long getRespuestasDelAnioPositivas(Integer year) {
        return respuestaDao.countByFechaAndRespuesta(getFirstTimeYear(year), getLastTimeYear(year),true);
    }

    public Long getRespuestasDelAnioNegativas(Integer year) {
        return respuestaDao.countByFechaAndRespuesta(getFirstTimeYear(year), getLastTimeYear(year),false);
    }

    private Date getFirstTimeYear(Integer year){
        return getFirstTimeMonth(0,year);
    }


    private Date getLastTimeYear(Integer year){
        return getLastTimeMonth(11,year);
    }


    private Calendar getMonthInstance(Integer month, Integer year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        return calendar;
    }

    private Date getFirstTimeMonth(Integer month, Integer year){
        Calendar calendar = getMonthInstance(month,year);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return getFirstTime(calendar.getTime());
    }

    private Date getLastTimeMonth(Integer month, Integer year){
        Calendar calendar = getMonthInstance(month,year);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getLastTime(calendar.getTime());
    }


    private Date getFirstTime(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    private Date getLastTime(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

}
