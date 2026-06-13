package com.joaodev.it_equipment_manager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "modelo", length = 100, nullable = false)
    private String modelo;

    @Column(name = "fabricante", length = 100, nullable = false)
    private String fabricante;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_equipamento", length = 30, nullable = false)
    private TipoEquipamento tipoEquipamento;
}
