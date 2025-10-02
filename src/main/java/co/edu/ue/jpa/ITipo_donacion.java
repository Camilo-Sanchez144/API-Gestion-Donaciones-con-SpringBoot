package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Tipo_donacion;

@Repository
public interface ITipo_donacion extends JpaRepository<Tipo_donacion, Integer> {
    
    // Buscar todos los tipos de donación por ID de donación usando @Query
    @Query("SELECT t FROM Tipo_donacion t WHERE t.id_donacion = :idDonacion")
    List<Tipo_donacion> findByIdDonacion(@Param("idDonacion") int idDonacion);
    
    // Buscar por tipo específico usando @Query
    @Query("SELECT t FROM Tipo_donacion t WHERE t.tipo_donacion = :tipoDonacion")
    List<Tipo_donacion> findByTipoDonacion(@Param("tipoDonacion") String tipoDonacion);
    
    // Verificar si existe un tipo de donación para una donación específica
    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Tipo_donacion t WHERE t.id_donacion = :idDonacion")
    boolean existsByIdDonacion(@Param("idDonacion") int idDonacion);
}
