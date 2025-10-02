package co.edu.ue.service;
import java.util.List;
import co.edu.ue.entity.Receptor;

public interface IReceptorService {
    List<Receptor> listAll();
    Receptor addReceptor(Receptor receptor);
    Receptor updateReceptor(Receptor receptor);
    Receptor findReceptorById(int id);
    Receptor findReceptorByIdUsuario(int idUsuario);
    void deleteReceptorById(int id);
    boolean receptorExists(int id);
}
