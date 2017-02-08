package ar.com.soyseeb.rest.controllers;

import ar.com.soyseeb.core.exceptions.PreguntaNotExistException;
import ar.com.soyseeb.core.model.Pregunta;
import ar.com.soyseeb.core.model.Respuesta;
import ar.com.soyseeb.core.services.PreguntaService;
import ar.com.soyseeb.core.services.RespuestaService;
import ar.com.soyseeb.rest.dto.EncuestaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Optional;

/**
 * Created by sbogado on 30/01/2017.
 */
@RestController
@RequestMapping("/api/encuesta")
@CrossOrigin //TODO sacarla cuando esté productivo
public class EncuestaController {

    @Autowired
    private PreguntaService preguntaService;

    @Autowired
    private RespuestaService respuestaService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/pregunta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pregunta getPregunta() throws PreguntaNotExistException {
        Optional<Pregunta> pregunta =  preguntaService.getPreguntaActual();
        if(!pregunta.isPresent()){
            throw new PreguntaNotExistException("No hay preguntas disponibles para realizar la encuesta");
        }
        return pregunta.get();
    }

    @RequestMapping(value = "/respuesta", method = RequestMethod.POST)
    public EncuestaDTO saveRespuesta(@RequestBody Respuesta respuesta ) throws PreguntaNotExistException {
        Optional<Pregunta> pregunta = preguntaService.getPreguntaById(respuesta.getPregunta().getId());
        if(!pregunta.isPresent()){
            throw new PreguntaNotExistException("No se ha encontrado la pregunta asociada a la respuesta");
        }
        respuesta = respuestaService.save(respuesta);
        pregunta.get().addRespuesta(respuesta);
        preguntaService.savePregunta(pregunta.get());

        EncuestaDTO encuestaDTO = new EncuestaDTO();
        encuestaDTO.setPregunta(pregunta.get());
        encuestaDTO.setRespuesta(respuesta);
        encuestaDTO.setMessage(messageSource.getMessage("ar.com.tssa.climalaboral.graciasporcolaborar",null,Locale.getDefault()));
        return encuestaDTO;
    }

}
