package com.example.labschool.dtos;

import lombok.Data;

import java.util.Date;

public record AcompanhamentoPedDTO(
        String titulo,
        String aluno,
        String pedagogo,
        Date dataAcompanhamento,
        boolean finalizado

) {
}
