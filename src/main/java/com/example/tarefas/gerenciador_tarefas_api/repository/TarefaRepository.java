package com.example.tarefas.gerenciador_tarefas_api.repository;

import com.example.tarefas.gerenciador_tarefas_api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 1. Marca a interface como um componente de persistência do Spring
public interface TarefaRepository extends JpaRepository<Tarefa, Long> { }
