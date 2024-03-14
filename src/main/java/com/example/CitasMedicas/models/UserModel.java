package com.example.CitasMedicas.models;

import jakarta.persistence.*;
import lombok.*;

@Entity // Marcamos la clase como entidad persistente
// Agregamos constructores mediante Loombok, getters y seters mediante Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance (strategy = InheritanceType.JOINED) // Convertimos a la tabla usuario en padre
@Table(name = "usuario")
public class UserModel {
    // Declaramos las variables de la clase User
    @Id // @Id se usa para identificar el primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generamos automáticamente los valores para la clave primaria ID
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String usuario;

    @Column
    private String clave;

}
