package com.example.labschool.dtos;

import com.example.labschool.models.AlunoModel;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record AlunoDTO(
        @NotEmpty(message = "O campo nome é obrigatório.")
        String nome,
        @NotBlank(message = "O campo telefone é obrigatório.")
        @Size(min=16,max = 16)
        String telefone,
        @NotNull(message = "O campo Data de nascimento é obrigatório.")
        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date dataNascimento,
        @NotBlank(message = "O campo CPF é obrigatório.")
        @Size(min = 14, max = 14, message = "Campo CPF deve ter 14 caracteres (EX.:000.000.000-00).")
        String cpf,
        @NotNull @DecimalMin(value = "0.0", message = "O valor mínimo para nota é 0.0.")
        @DecimalMax(value = "100.0", message = "O valor máximo para nota é 100.0.")
        Float nota
) {

        public AlunoDTO(AlunoModel alunoModel){
                this(
                        alunoModel.getNome(),
                        alunoModel.getTelefone(),
                        alunoModel.getDataNascimento(),
                        alunoModel.getCpf(),
                        alunoModel.getNota()
                );
        }
}
