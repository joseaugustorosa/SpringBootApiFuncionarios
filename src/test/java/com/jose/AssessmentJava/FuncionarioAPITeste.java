package com.jose.AssessmentJava;

import com.jose.AssessmentJava.Controller.FuncionarioController;
import com.jose.AssessmentJava.model.Funcionario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FuncionarioController.class)
public class FuncionarioAPITeste {
    @Autowired
    private MockMvc mockMvc;
    private Funcionario funcionario;
    @MockBean
    private FuncionarioController funcionarioController;

    @Test
    public void getAllFuncionarios() throws Exception {
        when(funcionarioController.GetAllFuncionarios()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/funcionario"))
                .andExpect(status().isOk()).andExpect(content().string("[]"));
    }

}
