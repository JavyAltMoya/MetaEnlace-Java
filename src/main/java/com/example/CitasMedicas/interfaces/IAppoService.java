package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.models.AppoModel;
import com.example.CitasMedicas.models.MedicModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

public interface IAppoService {

    ArrayList<AppoModel> getCita();

    AppoModel guardarCita(AppoModel date);

    Optional<AppoModel> getById(Long id);

    AppoModel updateById(AppoModel request, Long id);

    Boolean deleteCita(Long id);

}
