package com.example.CitasMedicas.dto;

import lombok.*;

import java.util.Date;

// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppoDTO {
    // Declaramos los atributos
    private Long id;

    private Date fechaHora;

    private String motivoCita;

    private int attribute11;

    private Long pacienteId;

    private Long medicoId;

    private Long diagnosticoId;

}
