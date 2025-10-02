package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.usuario;

@Repository
public interface IusuarioJpa extends JpaRepository<usuario, Integer> {
    
    /**
     * Busca un usuario por su email
     * @param email email del usuario
     * @return usuario encontrado o null
     */
    usuario findByEmailusuario(String email);
}
