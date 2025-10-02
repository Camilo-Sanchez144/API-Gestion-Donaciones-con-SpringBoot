package co.edu.ue.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Receptor;
@Repository
public interface IReceptorJpa extends JpaRepository<Receptor, Integer> {
    @Query("SELECT r FROM Receptor r WHERE r.estado_receptor = :estadoReceptor")
    public List<Receptor> findByEstadoReceptor(@Param("estadoReceptor") byte estadoReceptor);
    
    @Query("SELECT r FROM Receptor r WHERE r.id_usuario = :idUsuario")
    public Optional<Receptor> findByIdUsuario(@Param("idUsuario") int idUsuario);
}
