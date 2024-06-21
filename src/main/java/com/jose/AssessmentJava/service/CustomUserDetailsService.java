package com.jose.AssessmentJava.service;

import com.jose.AssessmentJava.model.Usuario;
import com.jose.AssessmentJava.model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUsuarioByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario não cadastrado");
        }
        return new org.springframework.security.core.userdetails.User(usuario.getNome(), usuario.getSenha()
                , Collections.singletonList(new SimpleGrantedAuthority(usuario.getPapel())));
    }

}
