package com.example.tarefas.gerenciador_tarefas_api.controller;

import com.example.tarefas.gerenciador_tarefas_api.model.Aluno;
import com.example.tarefas.gerenciador_tarefas_api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno") // Novo path: /api/aluno
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    // POST: Criar Aluno
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // GET: Listar Todos
    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        return aluno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT: Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {

        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        alunoAtualizado.setId(id);
        Aluno alunoSalvo = alunoRepository.save(alunoAtualizado);

        return ResponseEntity.ok(alunoSalvo);
    }

    // DELETE: Remover
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> removerAluno(@PathVariable Long id) {

        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        alunoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
