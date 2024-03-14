package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.models.MedicModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IMedicService {
    ArrayList<MedicModel> getMedic();
    MedicModel guardarMedico(MedicModel user);
    Optional<MedicModel> getById(Long id);
    MedicModel updateById(MedicModel request, Long id);
    Boolean deleteMedic(Long id);
}
