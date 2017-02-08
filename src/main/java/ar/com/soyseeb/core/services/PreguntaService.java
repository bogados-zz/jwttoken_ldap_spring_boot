package ar.com.soyseeb.core.services;

import ar.com.soyseeb.core.dao.PreguntaDao;
import ar.com.soyseeb.core.model.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by sbogado on 05/12/2016.
 */
@Service
public class PreguntaService {

    @Autowired
    private PreguntaDao preguntaDao;

    public Optional<Pregunta> getPreguntaActual(){
        return preguntaDao.findByActive(true);
    }

    public Optional<Pregunta> getPreguntaById(Integer id){
        return preguntaDao.findPreguntaById(id);
    }

    public Pregunta savePregunta(Pregunta pregunta){
        if(pregunta.getActive()){
            Optional<Pregunta> optPregunta = getPreguntaActual();
            //Si hay una pregunta activa la deshabilito
            if(optPregunta.isPresent() && !optPregunta.get().getId().equals(pregunta.getId())){
                optPregunta.get().setActive(false);
                preguntaDao.save(optPregunta.get());
            }
        }
        return preguntaDao.save(pregunta);
    }

    public void deletePregunta(Pregunta pregunta){
         preguntaDao.delete(pregunta);
    }

    public List<Pregunta> getAllPreguntas() {
        return preguntaDao.findAll();
    }

    public void deletePregunta(Integer id) {
        preguntaDao.delete(id);
    }
}
