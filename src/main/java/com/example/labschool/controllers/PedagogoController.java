package com.example.labschool.controllers;

import com.example.labschool.dtos.PedagogoDTO;
import com.example.labschool.models.PedagogoModel;
import com.example.labschool.repositories.PedagogoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class PedagogoController {
    @Autowired
    private PedagogoRepository pedagogoRepository;

    @PostMapping("/pedagogo")
    public ResponseEntity<PedagogoModel> savePedagogo(@RequestBody @Valid PedagogoDTO newPedagogo){
        var pedagodoModel = new PedagogoModel();
        BeanUtils.copyProperties(newPedagogo,pedagodoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedagogoRepository.save(pedagodoModel));
        //return new ResponseEntity<PedagogoModel>(pedagogoRepository.save(pedagodoModel),HttpStatus.CREATED);
    }

    @GetMapping("pedagogos")
    public ResponseEntity<List<PedagogoDTO>> getAllPedagogos(){
        return ResponseEntity.status(HttpStatus.OK).body(this.pedagogoRepository.findAll().stream().map(
                PedagogoDTO::new).toList());
    }

    @GetMapping("pedagogo/{id}")
    public ResponseEntity<Object> getOnePedagogo(@PathVariable(value = "id") UUID id){
        Optional<PedagogoModel> pedagogoO = this.pedagogoRepository.findById(id);
        if(pedagogoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedagogo not found.");
        }
        Optional<PedagogoDTO> pedagogoDTO = pedagogoO.map(PedagogoDTO::new);
        return ResponseEntity.status(HttpStatus.OK).body(pedagogoDTO.get());
    }

    @PutMapping("pedagogo/{id}")
    public ResponseEntity<Object> updatePedagogo(@PathVariable(value="id") UUID id,@RequestBody @Valid PedagogoDTO pedagogoDTO){
        Optional<PedagogoModel> pedagogogO = this.pedagogoRepository.findById(id);
        if(pedagogogO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedagogo not Found.");
        }
        var pedagogoModel = pedagogogO.get();
        BeanUtils.copyProperties(pedagogoDTO,pedagogoModel);
        return  ResponseEntity.status(HttpStatus.OK).body(this.pedagogoRepository.save(pedagogoModel));
    }

    @DeleteMapping("pedagogo/{id}")
    public ResponseEntity<Object> deletePedagogo(@PathVariable(value = "id")UUID id){
        Optional<PedagogoModel> pedagogoO = this.pedagogoRepository.findById(id);
        if(pedagogoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedagogo not found.");
        }
        this.pedagogoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pedagogo deleted successfully.");
    }
}
