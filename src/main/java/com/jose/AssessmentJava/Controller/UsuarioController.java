package com.jose.AssessmentJava.Controller;

import com.jose.AssessmentJava.model.Usuario;
import com.jose.AssessmentJava.model.UsuarioRepository;
import com.jose.AssessmentJava.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));;
        return usuarioService.salvarUsuario(usuario);
    }
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.findAll();

    }

}
