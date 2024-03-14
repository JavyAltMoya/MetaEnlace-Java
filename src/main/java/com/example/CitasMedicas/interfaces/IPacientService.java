package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.models.PacientModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IPacientService {
    ArrayList<PacientModel> getPacient();
    PacientModel guardarPaciente(PacientModel user);
    Optional<PacientModel> getById(Long id);
    PacientModel updateById(PacientModel request, Long id);
    Boolean deletePacient(Long id);
}
