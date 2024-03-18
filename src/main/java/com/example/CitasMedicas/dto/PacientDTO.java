package com.example.CitasMedicas.dto;

import lombok.*;

// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacientDTO {
    // Declaramos las variables de la clase Pacient
    private Long id;

    private String nss;

    private String numTarjeta;

    private String telefono;

    private String direccion;

}
