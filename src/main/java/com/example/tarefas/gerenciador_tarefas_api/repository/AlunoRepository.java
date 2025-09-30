package com.example.tarefas.gerenciador_tarefas_api.repository;


import com.example.tarefas.gerenciador_tarefas_api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
