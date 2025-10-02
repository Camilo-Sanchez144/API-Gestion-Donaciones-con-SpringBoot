package co.edu.ue.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.entity.Donante;
import co.edu.ue.entity.Receptor;
import co.edu.ue.entity.usuario;
import co.edu.ue.jpa.IDonanteJpa;
import co.edu.ue.jpa.IReceptorJpa;
import co.edu.ue.jpa.IusuarioJpa;

@Service
public class RegistroUsuarioService {
    
    @Autowired
    private IusuarioJpa usuarioJpa;
    
    @Autowired
    private IDonanteJpa donanteJpa;

    @Autowired
    private IReceptorJpa receptorJpa;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public usuario registrarDonante(RegistroUsuarioRequest request) {
        try {
            usuario nuevoUsuario = new usuario();
            nuevoUsuario.setEmailusuario(request.getEmail());
            // Hashear la contraseña antes de guardarla
            String contrasenaHasheada = passwordEncoder.encode(request.getContrasena());
            nuevoUsuario.setContrasenausuario(contrasenaHasheada);
            nuevoUsuario.setSaltusuario(request.getSalt());
            nuevoUsuario.setUsername(request.getNombre());
            nuevoUsuario.setRolusuario("DONANTE");
            nuevoUsuario.setFecha_creacionusuario(LocalDateTime.now());
            
            usuario usuarioGuardado = usuarioJpa.save(nuevoUsuario);
            
            Donante nuevoDonante = new Donante();
            nuevoDonante.setId_usuario(usuarioGuardado.getId_usuario());
            nuevoDonante.setNombre_donante(request.getNombre_donante());
            nuevoDonante.setTipo_donante(request.getTipo_donante());
            nuevoDonante.setDireccion(request.getDireccion_donante());
            nuevoDonante.setCiudad(request.getCiudad_donante());
            nuevoDonante.setCodigo_postal(request.getCodigo_postal_donante());
            nuevoDonante.setTelefono_contacto(request.getTelefono_contacto_donante());
            nuevoDonante.setEmail_contacto(request.getEmail_contacto_donante());
            nuevoDonante.setEstadoDonante(request.getEstado_donante() != null ? request.getEstado_donante() : (byte) 1);
            
            donanteJpa.save(nuevoDonante);
            
            return usuarioGuardado;
            
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar donante: " + e.getMessage(), e);
        }
    }

    @Transactional
    public usuario registrarReceptor(RegistroUsuarioRequest request) {
        try {
            usuario nuevoUsuario = new usuario();
            nuevoUsuario.setEmailusuario(request.getEmail());
            // Hashear la contraseña antes de guardarla
            String contrasenaHasheada = passwordEncoder.encode(request.getContrasena());
            nuevoUsuario.setContrasenausuario(contrasenaHasheada);
            nuevoUsuario.setSaltusuario(request.getSalt());
            nuevoUsuario.setUsername(request.getNombre());
            nuevoUsuario.setRolusuario("RECEPTOR");
            nuevoUsuario.setFecha_creacionusuario(LocalDateTime.now());
            
            usuario usuarioGuardado = usuarioJpa.save(nuevoUsuario);
            
            Receptor nuevoReceptor = new Receptor();
            nuevoReceptor.setId_usuario(usuarioGuardado.getId_usuario());
            nuevoReceptor.setNombre_receptor(request.getNombre_receptor());
            nuevoReceptor.setTipo_organizacion(request.getTipo_organizacion());
            nuevoReceptor.setDireccion(request.getDireccion_receptor());
            nuevoReceptor.setCiudad(request.getCiudad_receptor());
            nuevoReceptor.setCodigo_postal(request.getCodigo_postal_receptor());
            nuevoReceptor.setTelefono_contacto(request.getTelefono_contacto_receptor());
            nuevoReceptor.setEmail_contacto(request.getEmail_contacto_receptor());

            receptorJpa.save(nuevoReceptor);

            return usuarioGuardado;
            
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar receptor: " + e.getMessage(), e);
        }
    }

    public List<usuario> listAllusuarios() {
        return usuarioJpa.findAll();
    }
}