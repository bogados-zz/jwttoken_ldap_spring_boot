package ar.com.soyseeb.rest.controllers;

import ar.com.soyseeb.core.exceptions.BussinessException;
import ar.com.soyseeb.core.exceptions.PreguntaNotExistException;
import ar.com.soyseeb.core.model.Pregunta;
import ar.com.soyseeb.core.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by sbogado on 30/01/2017.
 */
@RestController
@RequestMapping(value="admin/api/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Pregunta> getAllPreguntas(){
        return preguntaService.getAllPreguntas();
    }

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public Pregunta getPreguntaById(@PathVariable Integer id) throws BussinessException {
        Optional<Pregunta> optPregunta = preguntaService.getPreguntaById(id);
        if(!optPregunta.isPresent()){
            throw new PreguntaNotExistException();
    }
        return optPregunta.get();
    }

    @RequestMapping(value="/save", method = RequestMethod.PUT)
    public Pregunta savePregunta(@RequestBody @Valid Pregunta pregunta){
        return preguntaService.savePregunta(pregunta);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void deletePregunta(@PathVariable Integer id){
        preguntaService.deletePregunta(id);
    }

}
