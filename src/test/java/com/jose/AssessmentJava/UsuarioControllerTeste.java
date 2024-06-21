package com.jose.AssessmentJava;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jose.AssessmentJava.Controller.UsuarioController;
import com.jose.AssessmentJava.model.Usuario;
import com.jose.AssessmentJava.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTeste {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void salvarUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId("1");
        usuario.setNome("Jose");
        usuario.setPapel("User");
        given(usuarioService.salvarUsuario(any(Usuario.class))).willReturn(usuario);

        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("Jose"));
    }

}
