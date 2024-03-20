package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.dto.MedicDTO;
import com.example.CitasMedicas.models.MedicModel;

import java.util.List;
import java.util.Optional;

public interface IMedicService {
    List<MedicDTO> getMedic();
    MedicDTO guardarMedico(MedicModel user);
    Optional<MedicDTO> getById(Long id);
    MedicDTO updateById(MedicModel request, Long id);
    Boolean deleteMedic(Long id);
}
