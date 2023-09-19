package com.example.labschool.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class PessoaModel {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    private String nome;

    private String telefone;

    private Date dataNascimento;

    private String cpf;
}
