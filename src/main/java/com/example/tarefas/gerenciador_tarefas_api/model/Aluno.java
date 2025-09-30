package com.example.tarefas.gerenciador_tarefas_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "ru", nullable = false, unique = true) // RU como único
    private String ru;

    public void setId(Long id){
        this.id = id;
    }
}
