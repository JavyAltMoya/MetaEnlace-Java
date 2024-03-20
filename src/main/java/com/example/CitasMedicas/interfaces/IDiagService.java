package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.dto.DiagDTO;
import com.example.CitasMedicas.models.DiagModel;

import java.util.List;
import java.util.Optional;

public interface IDiagService {

    List<DiagDTO> getDiag();

    DiagDTO guardarDiag(DiagModel diag);

    Optional<DiagDTO> getById(Long id);

    DiagDTO updateById(DiagModel request, Long id);

    Boolean deleteDiag(Long id);

}
