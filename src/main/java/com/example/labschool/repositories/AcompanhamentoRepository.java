package com.example.labschool.repositories;

import com.example.labschool.dtos.AcompanhamentoPedDTO;
import com.example.labschool.models.AcompanhamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AcompanhamentoRepository extends JpaRepository<AcompanhamentoModel, UUID> {

    @Query(value =
            "SELECT new com.example.labschool.dtos.AcompanhamentoPedDTO(ac.titulo, al.nome,pd.nome,ac.dataAcompanhamento,ac.finalizado) " +
                    "FROM com.example.labschool.models.AcompanhamentoModel ac " +
                    "INNER JOIN ac.aluno al " +
                    "INNER JOIN ac.pedagogo pd")
    List<AcompanhamentoPedDTO> findAllAcompanhamentos();
}
