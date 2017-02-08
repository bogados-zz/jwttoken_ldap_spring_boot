package ar.com.soyseeb.core.dao;

import ar.com.soyseeb.core.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by sbogado on 25/01/2017.
 */
@Repository
public interface PreguntaDao extends JpaRepository<Pregunta, Integer>{

    Optional<Pregunta> findByActive(Boolean isActive);

    Optional<Pregunta> findPreguntaById(Integer id);


}
