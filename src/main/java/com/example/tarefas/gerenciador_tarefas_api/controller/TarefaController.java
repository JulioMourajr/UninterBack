package com.example.tarefas.gerenciador_tarefas_api.controller;

import com.example.tarefas.gerenciador_tarefas_api.model.Tarefa;
import com.example.tarefas.gerenciador_tarefas_api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        return tarefa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {

        if (!tarefaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        tarefaAtualizada.setId(id);
        Tarefa tarefaSalva = tarefaRepository.save(tarefaAtualizada);

        return ResponseEntity.ok(tarefaSalva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> removerTarefa(@PathVariable Long id) {

        if (!tarefaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        tarefaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
