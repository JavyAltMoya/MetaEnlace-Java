package com.example.CitasMedicas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity // Marcamos la clase como entidad persistente
// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cita")
public class AppoModel {

    // Declaramos los atributos
    @Id // @Id se usa para identificar el primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generamos automáticamente los valores para la clave primaria ID
    private Long id;

    @Column
    private Date fechaHora;

    @Column
    private String motivoCita;

    @Column
    private int attribute11;

    // Realizamos la relación con paciente y medico mediante el Muchos a Uno
    @ManyToOne
    @JoinColumn(name= "id_pacient")
    private PacientModel paciente;

    @ManyToOne
    @JoinColumn(name= "id_medic")
    private MedicModel medico;

    // Realizamos la relación con diagnóstico mediante el Uno a Uno
    @OneToOne(mappedBy = "cita", cascade = CascadeType.ALL)
    private DiagModel diagnostico;
}
