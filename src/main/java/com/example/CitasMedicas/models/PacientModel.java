package com.example.CitasMedicas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Agregamos constructores mediante Loombok, getters y seters mediante Builder y Data
@EqualsAndHashCode(callSuper = true) // Obtiene lo heredado del Padre
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // Marcamos la clase como entidad persistente
@PrimaryKeyJoinColumn(referencedColumnName = "id", name="id_usuario") // Introducimos la clave primaria del padre dentro de la tabla paciente
@Table(name = "paciente")
public class PacientModel extends UserModel {
    // Declaramos las variables de la clase Pacient
    @Column(unique = true)
    private String nss;

    @Column(unique = true)
    private String numTarjeta;

    @Column
    private String telefono;

    @Column
    private String direccion;

    // Creamos la lista donde almacenaremos los médicos
    @ManyToMany(mappedBy = "pacientesList")
    private List<MedicModel> medicosList;

    // Creamos la lista donde almacenaremos las citas como paciente
    @OneToMany(mappedBy = "paciente")
    private List<AppoModel> citasList;
}
