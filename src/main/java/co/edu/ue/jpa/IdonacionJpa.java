package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.donacion;
@Repository
public interface IdonacionJpa extends JpaRepository<donacion, Integer> {
}
