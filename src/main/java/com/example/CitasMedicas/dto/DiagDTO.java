package com.example.CitasMedicas.dto;

import lombok.*;

// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiagDTO {
    // Declaramos los atributos
    private Long id;

    private String valoracionEspecialista;

    private String enfermedad;

}
