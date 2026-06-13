package com.joaodev.it_equipment_manager.repository;

import com.joaodev.it_equipment_manager.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItEquipmentRepository extends JpaRepository<Equipamento, UUID> {
}
