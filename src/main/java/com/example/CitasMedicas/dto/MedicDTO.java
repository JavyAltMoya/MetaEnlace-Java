package com.example.CitasMedicas.dto;

import lombok.*;


// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicDTO {
    // Declaramos las variables de la clase Medic
    private Long id;

    private String numColegiado;

}
