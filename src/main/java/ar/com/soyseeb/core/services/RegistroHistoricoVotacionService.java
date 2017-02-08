package ar.com.soyseeb.core.services;

import ar.com.soyseeb.core.dao.RegistroHistoricoVotacionDao;
import ar.com.soyseeb.core.model.RegistroHistoricoVotacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * Created by sbogado on 07/12/2016.
 */
@Service
public class RegistroHistoricoVotacionService {

    @Autowired
    private RegistroHistoricoVotacionDao registroHistoricoHistoricoDao;


    public RegistroHistoricoVotacion save(RegistroHistoricoVotacion registroHistoricoVotacion){
        return registroHistoricoHistoricoDao.save(registroHistoricoVotacion);
    }



    public Optional<RegistroHistoricoVotacion> findByIpToday(String address) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date begin=calendar.getTime();

        calendar.setTime(begin);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date end = calendar.getTime();

        return registroHistoricoHistoricoDao.findByIpToday(address, begin, end);

    }
}
