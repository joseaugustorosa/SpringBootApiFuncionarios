package com.jose.AssessmentJava;

import com.jose.AssessmentJava.Controller.FuncionarioController;
import com.jose.AssessmentJava.model.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FuncionarioTeste {
    @Mock
    private FuncionarioController funcionarioController;
    @InjectMocks
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getFuncionario() {
        when(funcionarioController.GetAllFuncionarios()).thenReturn(new ArrayList<>());
        assertEquals(new ArrayList<>(), funcionarioController.GetAllFuncionarios());
        verify(funcionarioController,times(1)).GetAllFuncionarios();
    }

    @Test
    void setFuncionario() {
        when(funcionarioController.createFuncionario(funcionario)).thenReturn(funcionario);
        assertEquals(funcionario, funcionarioController.createFuncionario(funcionario));
        verify(funcionarioController,times(1)).createFuncionario(funcionario);

    }
}
