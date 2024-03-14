package com.example.CitasMedicas.dto;

import lombok.*;

import java.util.List;

// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacientDTO {
    // Declaramos las variables de la clase Pacient
    private Long id;

    private String nombre;

    private String apellidos;

    private String usuario;

    private String clave;

    private String nss;

    private String numTarjeta;

    private String telefono;

    private String direccion;

    private List<MedicDTO> medicosList;

    private List<AppoDTO> citasList;

}
