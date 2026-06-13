package com.joaodev.it_equipment_manager.controller;

import com.joaodev.it_equipment_manager.model.Equipamento;
import com.joaodev.it_equipment_manager.service.EquipamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    public Equipamento criar(@RequestBody Equipamento equipamento) {
        return service.salvar(equipamento);
    }

    @PutMapping("/{id}")
    public Equipamento atualizar(@PathVariable UUID id, @RequestBody Equipamento equipamento) {
        return service.atualizarPorId(id, equipamento);  
    }

    @GetMapping("/{id}")
    public Optional<Equipamento> buscar(@PathVariable UUID id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable UUID id) {
        service.remover(id);
    }
}
