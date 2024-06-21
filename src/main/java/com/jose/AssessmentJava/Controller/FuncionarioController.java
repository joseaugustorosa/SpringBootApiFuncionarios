package com.jose.AssessmentJava.Controller;

import com.jose.AssessmentJava.model.Departamento;
import com.jose.AssessmentJava.model.DepartamentoRepository;
import com.jose.AssessmentJava.model.Funcionario;
import com.jose.AssessmentJava.model.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private DepartamentoRepository departamentoController;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @PostMapping("Departamento/{funcionarioID}")
    public Funcionario adicionarDepartamento(@RequestBody Departamento departamento, @PathVariable long funcionarioID) {
        return funcionarioRepository.findById(funcionarioID).map(funcionario -> {
            funcionario.setDepartamento(departamento);
            return funcionarioRepository.save(funcionario);
                }

        ).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
    }
    @GetMapping
    public Iterable<Funcionario> GetAllFuncionarios() {
        return  funcionarioRepository.findAll();
    }
    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
    }
    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFuncionario(@PathVariable long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado" + id));
        funcionarioRepository.delete(funcionario);
        return ResponseEntity.ok().build();

    }
    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable long id, @RequestBody Funcionario funcionario) {
        Funcionario func = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado" + id));
        func.setNome(funcionario.getNome());
        return funcionarioRepository.save(func);
    }
}

