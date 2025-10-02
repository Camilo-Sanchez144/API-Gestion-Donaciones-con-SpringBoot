package co.edu.ue.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Donante;
@Repository
public interface IDonanteJpa extends JpaRepository<Donante, Integer> {
    List<Donante> findByEstadoDonante(Byte estadoDonante);
    
    @Query("SELECT d FROM Donante d WHERE d.id_usuario = :idUsuario")
    Optional<Donante> findByIdUsuario(@Param("idUsuario") int idUsuario);
}
