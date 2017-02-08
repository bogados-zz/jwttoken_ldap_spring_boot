package ar.com.soyseeb.core.dao;

import ar.com.soyseeb.core.model.RegistroHistoricoVotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

/**
 * Created by sbogado on 07/12/2016.
 */
@Repository
public interface RegistroHistoricoVotacionDao extends JpaRepository<RegistroHistoricoVotacion, Long> {

    @Query(value = "SELECT r FROM RegistroHistoricoVotacion r  " +
            "WHERE r.ip = ?1 " +
            "AND r.fecha BETWEEN ?2 AND ?3")
    Optional<RegistroHistoricoVotacion> findByIpToday(String address, Date begin, Date end);
}
