package com.example.labschool.dtos;

import com.example.labschool.models.PedagogoModel;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Date;

public record PedagogoDTO(
        @NotEmpty(message = "O campo nome é obrigatório.")
        String nome,
        @NotBlank(message = "O campo telefone é obrigatório.")
        @Size(min=16,max = 16)
        String telefone,
        @NotNull(message = "O campo Data de nascimento é obrigatório.")
        @Temporal(TemporalType.DATE)
        Date dataNascimento,
        @NotBlank(message = "O campo CPF é obrigatório.")
        @Size(min = 14, max = 14, message = "Campo CPF deve ter 14 caracteres (EX.:000.000.000-00).")
        String cpf,

        @NotBlank(message = "O campo E-mail é obrigatório.")
        @Email(message = "O campo E-mail deve ser um endereço de e-mail válido.")
        String email,
        @NotBlank @Size(min = 8)
        @Getter(AccessLevel.NONE)
        String senha
) {
        public PedagogoDTO(PedagogoModel pedagogo){
                this(
                        pedagogo.getNome(),
                        pedagogo.getTelefone(),
                        pedagogo.getDataNascimento(),
                        pedagogo.getCpf(),
                        pedagogo.getEmail(),
                        pedagogo.getSenha()
                );
        }
}
