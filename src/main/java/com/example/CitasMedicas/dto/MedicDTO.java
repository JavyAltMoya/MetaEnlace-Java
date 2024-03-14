package com.example.CitasMedicas.dto;

import lombok.*;

import java.util.List;


// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicDTO {
    // Declaramos las variables de la clase Medic
    private Long id;

    private String nombre;

    private String apellidos;

    private String usuario;

    private String clave;

    private String numColegiado;

    private List<PacientDTO> pacientesList;

    private List<AppoDTO> citasList;

}
