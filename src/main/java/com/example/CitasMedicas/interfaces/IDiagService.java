package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.models.DiagModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IDiagService {

    ArrayList<DiagModel> getDiag();

    DiagModel guardarDiag(DiagModel diag);

    Optional<DiagModel> getById(Long id);

    DiagModel updateById(DiagModel request, Long id);

    Boolean deleteDiag(Long id);

}
