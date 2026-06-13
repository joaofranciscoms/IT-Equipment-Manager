package com.joaodev.it_equipment_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.joaodev.it_equipment_manager.view.TelaEquipamento;

@SpringBootApplication
public class ItEquipmentManagerApplication {

	public static void main(String[] args) {
            // Inicia o Spring em modo Desktop (headless false)
            var context = new org.springframework.boot.builder.SpringApplicationBuilder(ItEquipmentManagerApplication.class)
            .headless(false)
            .run(args);

            // Pede para o Spring entregar a tela com o Service já injetado dentro dela
            java.awt.EventQueue.invokeLater(() -> {
                TelaEquipamento tela = context.getBean(TelaEquipamento.class);
                tela.setVisible(true);
            });
	}
}
