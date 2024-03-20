package com.example.CitasMedicas.dto;

import lombok.*;


// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    // Declaramos los atributos
    private Long id;

    private String nombre;

    private String apellidos;

    private String usuario;

    private String clave;
}
