package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.dto.AppoDTO;
import com.example.CitasMedicas.models.AppoModel;

import java.util.List;
import java.util.Optional;

public interface IAppoService {

    List<AppoDTO> getCita();

    AppoDTO guardarCita(AppoDTO date);

    Optional<AppoDTO> getById(Long id);

    AppoDTO updateById(AppoModel request, Long id);

    Boolean deleteCita(Long id);

}
