package com.joaodev.it_equipment_manager.service;

import com.joaodev.it_equipment_manager.model.Equipamento;
import com.joaodev.it_equipment_manager.repository.ItEquipmentRepository;
import org.springframework.stereotype.Service;
import com.joaodev.it_equipment_manager.model.TipoEquipamento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EquipamentoService {

    private final ItEquipmentRepository repository;

    public EquipamentoService(ItEquipmentRepository repository) {
        this.repository = repository;
    }

    public Equipamento salvar(Equipamento equipamento) {
        return repository.save(equipamento);
    }
    
    public Equipamento atualizarPorId(UUID id, Equipamento equipamento) {  
        Optional<Equipamento> retorno = repository.findById(id);
        
        if(retorno.isPresent()){
            Equipamento eq = retorno.get();
            
            eq.setModelo(equipamento.getModelo());
            eq.setFabricante(equipamento.getFabricante());
            eq.setTipoEquipamento(equipamento.getTipoEquipamento());
            
            return repository.save(eq);
        }
        else{
            throw new RuntimeException("ID não encontrado");
        }
    }

    public Optional<Equipamento> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    public void remover(UUID id) {
        Optional<Equipamento> retorno = repository.findById(id);
        
        if(retorno.isPresent()){
            Equipamento eq = retorno.get();
            repository.delete(eq);
        }
        else{
            throw new RuntimeException("ID não encontrado");
        }
    }
}
