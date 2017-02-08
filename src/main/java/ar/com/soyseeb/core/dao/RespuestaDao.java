package ar.com.soyseeb.core.dao;

import ar.com.soyseeb.core.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by sbogado on 05/12/2016.
 */
@Repository
public interface RespuestaDao extends JpaRepository<Respuesta, Long> {


    @Query(value="SELECT r from Respuesta r " +
            "WHERE r.fecha BETWEEN :begin AND :finish "+
            "AND r.respuesta = :state ")
    public List<Respuesta> findAllRespuestaByFechaAndRespuesta( @Param("begin") Date begin, @Param("finish") Date end, @Param("state")Boolean state);

    @Query(value="SELECT COUNT(r) from Respuesta r " +
            "WHERE r.fecha BETWEEN :begin AND :finish "+
            "AND r.respuesta = :state ")
    Long countByFechaAndRespuesta(@Param("begin") Date begin, @Param("finish") Date end, @Param("state") Boolean state);
    public List<Respuesta> findAllRespuestaByFecha(Date begin, Date end);



}
