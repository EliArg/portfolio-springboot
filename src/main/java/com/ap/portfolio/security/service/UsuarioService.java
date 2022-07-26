package com.ap.portfolio.security.service;

import com.ap.portfolio.security.entity.Usuario;
import com.ap.portfolio.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByUsuario(String username){
        return usuarioRepository.findByUsername(username);
    }

    public Boolean existsByUsuario(String username){
        return usuarioRepository.existsByUsername(username);
    }

    public Boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }


}