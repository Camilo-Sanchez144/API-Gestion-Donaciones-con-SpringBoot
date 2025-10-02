package co.edu.ue.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.LoginRequest;
import co.edu.ue.dto.LoginResponse;
import co.edu.ue.entity.Donante;
import co.edu.ue.entity.Receptor;
import co.edu.ue.entity.usuario;
import co.edu.ue.jpa.IDonanteJpa;
import co.edu.ue.jpa.IReceptorJpa;
import co.edu.ue.jpa.IusuarioJpa;

/**
 * Servicio para manejar la autenticación de usuarios
 */
@Service
public class AuthService {
    
    @Autowired
    private IusuarioJpa usuarioJpa;
    
    @Autowired
    private IDonanteJpa donanteJpa;
    
    @Autowired
    private IReceptorJpa receptorJpa;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
     * Autentica un usuario con email y contraseña
     * @param loginRequest datos de login
     * @return respuesta con información del usuario autenticado
     */
    public LoginResponse authenticate(LoginRequest loginRequest) {
        try {
            // Validar que los campos no estén vacíos
            if (loginRequest.getEmail() == null || loginRequest.getEmail().trim().isEmpty()) {
                return new LoginResponse(false, "El email es obligatorio");
            }
            
            if (loginRequest.getContrasena() == null || loginRequest.getContrasena().trim().isEmpty()) {
                return new LoginResponse(false, "La contraseña es obligatoria");
            }
            
            // Buscar usuario por email
            usuario usuarioEncontrado = usuarioJpa.findByEmailusuario(loginRequest.getEmail());
            
            if (usuarioEncontrado == null) {
                return new LoginResponse(false, "Usuario no encontrado");
            }
            
            // Verificar contraseña usando BCrypt
            if (!passwordEncoder.matches(loginRequest.getContrasena(), usuarioEncontrado.getContrasenausuario())) {
                return new LoginResponse(false, "Contraseña incorrecta");
            }
            
            // Crear respuesta exitosa
            LoginResponse response = new LoginResponse(
                true, 
                "Login exitoso", 
                usuarioEncontrado.getRolusuario(),
                usuarioEncontrado
            );
            
            // Buscar información adicional según el tipo de usuario
            if ("DONANTE".equals(usuarioEncontrado.getRolusuario())) {
                Optional<Donante> donanteOpt = donanteJpa.findByIdUsuario(usuarioEncontrado.getId_usuario());
                if (donanteOpt.isPresent()) {
                    response.setDonante(donanteOpt.get());
                }
            } else if ("RECEPTOR".equals(usuarioEncontrado.getRolusuario())) {
                Optional<Receptor> receptorOpt = receptorJpa.findByIdUsuario(usuarioEncontrado.getId_usuario());
                if (receptorOpt.isPresent()) {
                    response.setReceptor(receptorOpt.get());
                }
            }
            
            return response;
            
        } catch (Exception e) {
            return new LoginResponse(false, "Error interno del servidor: " + e.getMessage());
        }
    }
    
    /**
     * Verifica si un email ya existe en el sistema
     * @param email email a verificar
     * @return true si existe, false si no
     */
    public boolean emailExists(String email) {
        return usuarioJpa.findByEmailusuario(email) != null;
    }
}