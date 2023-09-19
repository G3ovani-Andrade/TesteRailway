package com.example.labschool.dtos;

import com.example.labschool.models.AlunoModel;
import com.example.labschool.models.PedagogoModel;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AcompanhamentoDTO(
        @NotNull
        AlunoModel aluno,
        @NotNull
        PedagogoModel pedagogo,
        @NotNull(message = "O campo Data do acompanhamento é obrigatório.")
        @Temporal(TemporalType.DATE)
        Date dataAcompanhamento,
        @NotEmpty(message = "O campo titulo é obrigatório.")
        String titulo,
        @NotEmpty(message = "O campo descrição é obrigatório.")
        String descricao,
        boolean finalizado
) {
}
