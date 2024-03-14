package com.example.CitasMedicas.models;

import jakarta.persistence.*;
import lombok.*;


@Entity // Marcamos la clase como entidad persistente
// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "diagnostico")
public class DiagModel {

    // Declaramos los atributos
    @Id // @Id se usa para identificar el primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generamos automáticamente los valores para la clave primaria ID
    private Long id;

    @Column
    private String valoracionEspecialista;

    @Column
    private String enfermedad;

    // Creamos la lista donde almacenaremos los diagnosticos en las citas
    @OneToOne(mappedBy = "diagnostico", cascade = CascadeType.ALL)
    private AppoModel cita;
}
