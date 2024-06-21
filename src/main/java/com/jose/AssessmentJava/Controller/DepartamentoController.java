package com.jose.AssessmentJava.Controller;

import com.jose.AssessmentJava.model.Departamento;
import com.jose.AssessmentJava.model.DepartamentoRepository;
import com.jose.AssessmentJava.model.Funcionario;
import com.jose.AssessmentJava.model.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departamentoController;
    @GetMapping
    public Iterable<Departamento> GetAlldepartamento() {
        return  departamentoController.findAll();
    }



    @GetMapping("/{id}")
    public Departamento getdepartamentoById(@PathVariable long id) {
        return departamentoController.findById(id).orElseThrow(() -> new RuntimeException("departamento não encontrado"));
    }
    @PostMapping
    public Departamento createdepartamento(@RequestBody Departamento departamento) {
        return departamentoController.save(departamento);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletedepartamento(@PathVariable long id) {
        Departamento departamento = departamentoController.findById(id).orElseThrow(() -> new RuntimeException("departamento não encontrado" + id));
        departamentoController.delete(departamento);
        return ResponseEntity.ok().build();

    }
    @PutMapping("/{id}")
    public Departamento updatedepartamento(@PathVariable long id, @RequestBody Departamento funcionario) {
        Departamento departamento = departamentoController.findById(id).orElseThrow(() -> new RuntimeException("departamento não encontrado" + id));
        departamento.setNome(departamento.getNome());
        return departamentoController.save(departamento);
    }
}
