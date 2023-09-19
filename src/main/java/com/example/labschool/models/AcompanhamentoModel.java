package com.example.labschool.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_ACOMPANHAMENTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcompanhamentoModel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private PedagogoModel pedagogo;

    private Date dataAcompanhamento;

    private String titulo;

    private String descricao;

    private boolean finalizado=false;
}
