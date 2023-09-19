package com.example.labschool.repositories;

import com.example.labschool.models.PedagogoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedagogoRepository extends JpaRepository<PedagogoModel, UUID> {

}
