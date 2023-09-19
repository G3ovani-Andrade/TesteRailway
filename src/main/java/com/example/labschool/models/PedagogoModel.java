package com.example.labschool.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="TB_PEDAGOGO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedagogoModel extends PessoaModel{

    private String email;

    private String senha;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "pedagogo")
    private List<AcompanhamentoModel> acompanhamentoPedagogicoModel;

}
