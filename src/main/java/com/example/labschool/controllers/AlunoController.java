package com.example.labschool.controllers;

import com.example.labschool.dtos.AlunoDTO;
import com.example.labschool.dtos.PedagogoDTO;
import com.example.labschool.models.AlunoModel;
import com.example.labschool.models.PedagogoModel;
import com.example.labschool.repositories.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("aluno")
    public ResponseEntity<AlunoModel> saveAluno(@RequestBody @Valid AlunoDTO newAluno){
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(newAluno,alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.alunoRepository.save(alunoModel));
    }

    @GetMapping("alunos")
    public ResponseEntity<List<AlunoDTO>> getAllAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(this.alunoRepository.findAll().stream().map(AlunoDTO::new).toList());
    }

    @GetMapping("aluno/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "id") UUID id){
        Optional<AlunoModel> alunoO = this.alunoRepository.findById(id);
        if(alunoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno not Found");
        }
        Optional<AlunoDTO> pedagogoDto = alunoO.map(AlunoDTO::new);
        return ResponseEntity.status(HttpStatus.OK).body(pedagogoDto.get());
    }

    @PutMapping("aluno/{id}")
    public ResponseEntity<Object> updateAluno(@PathVariable UUID id, @RequestBody @Valid AlunoDTO alunoDto){
        Optional<AlunoModel> alunoO = this.alunoRepository.findById(id);
        if(alunoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno not Found.");
        }
        var alunoModel = alunoO.get();
        BeanUtils.copyProperties(alunoDto,alunoModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.alunoRepository.save(alunoModel));
    }

    @DeleteMapping("aluno/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable UUID id){
        Optional<AlunoModel> alunoO = this.alunoRepository.findById(id);
        if(alunoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno not Found.");
        }
        this.alunoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deleted successfully.");
    }

}
