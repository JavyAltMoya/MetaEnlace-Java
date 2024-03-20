package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.dto.PacientDTO;
import com.example.CitasMedicas.models.PacientModel;

import java.util.List;
import java.util.Optional;

public interface IPacientService {
    List<PacientDTO> getPacient();
    PacientDTO guardarPaciente(PacientModel user);
    Optional<PacientDTO> getById(Long id);
    PacientDTO updateById(PacientModel request, Long id);
    Boolean deletePacient(Long id);
}
