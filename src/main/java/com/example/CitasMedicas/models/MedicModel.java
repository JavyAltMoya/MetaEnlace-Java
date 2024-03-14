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
@PrimaryKeyJoinColumn(referencedColumnName = "id", name="id_usuario") // Introducimos la clave primaria del padre dentro de la tabla médico
@Table(name = "medico")
public class MedicModel extends UserModel{

    // Declaramos las variables de la clase Medic
    @Column(unique = true)
    private String numColegiado;

    // Creamos la lista donde almacenaremos los pacientes
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable (
            name ="Medic-Pacient", joinColumns = @JoinColumn(name = "id_medic", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_pacient", referencedColumnName = "id_usuario")
    )
    private List<PacientModel> pacientesList;

    // Creamos la lista donde almacenaremos las citas como médico
    @OneToMany(mappedBy = "medico")
    private List<AppoModel> citasList;

}
