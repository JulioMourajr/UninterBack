package com.example.tarefas.gerenciador_tarefas_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tarefa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_entrega", nullable = false)
    private LocalDate dataEntrega;

    @Column(nullable = false)
    private String responsavel;

    public void setId(Long id){
        this.id = id;
    }
}
