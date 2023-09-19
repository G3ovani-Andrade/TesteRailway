package com.example.labschool.controllers;

import com.example.labschool.dtos.AcompanhamentoDTO;
import com.example.labschool.dtos.AcompanhamentoPedDTO;
import com.example.labschool.models.AcompanhamentoModel;
import com.example.labschool.models.AlunoModel;
import com.example.labschool.repositories.AcompanhamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/acompanhamento")
public class AcompanhamentoController {
    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    @PostMapping()
    public ResponseEntity<AcompanhamentoModel> saveAcompanhamento(@RequestBody @Valid AcompanhamentoDTO acompanhamentoDto){
        var acompanhamentoModel = new AcompanhamentoModel();
        BeanUtils.copyProperties(acompanhamentoDto,acompanhamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.acompanhamentoRepository.save(acompanhamentoModel));
    }

    @GetMapping
    public ResponseEntity<List<AcompanhamentoPedDTO>> getAllAcompanhamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(this.acompanhamentoRepository.findAllAcompanhamentos());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAcompanhamento(@PathVariable(value = "id")UUID id,
                                                       @RequestBody @Valid AcompanhamentoDTO acompanhamentoDTO){
        Optional<AcompanhamentoModel> acompanhamentoO = this.acompanhamentoRepository.findById(id);
        if(acompanhamentoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acompanhamento not Found.");
        }
        var acompanhamentoModel = acompanhamentoO.get();
        BeanUtils.copyProperties(acompanhamentoDTO,acompanhamentoModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.acompanhamentoRepository.save(acompanhamentoModel));
    }
}
