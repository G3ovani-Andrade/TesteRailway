package com.example.labschool.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "TB_ALUNO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoModel extends PessoaModel{

    private Float nota;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "aluno")
    private List<AcompanhamentoModel> acompanhamentoPedagogicoMOdel;
}
