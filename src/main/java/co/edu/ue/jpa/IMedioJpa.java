package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.medio;

@Repository
public interface IMedioJpa extends JpaRepository<medio, Integer> {
   
   // Usando @Query para evitar problemas con naming convention
   @Query("SELECT m FROM medio m WHERE m.estado_medio = :estadoMedio")
   List<medio> findByEstadoMedio(@Param("estadoMedio") String estadoMedio);
}
