package com.example.CitasMedicas.services;

import com.example.CitasMedicas.interfaces.IDiagService;
import com.example.CitasMedicas.models.DiagModel;
import com.example.CitasMedicas.repositories.IDiagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DiagService implements IDiagService {

    // Anotación para introducir dependencias
    @Autowired
    IDiagRepository diagRepository; // Repositorio de los diagnósticos

    /**
     * Método para obtener el array dónde se obtiene la lista de diagnósticos
     */
    public ArrayList<DiagModel> getDiag(){
        // Devuelve todos los diagnósticos del repositorio
        return (ArrayList<DiagModel>) diagRepository.findAll();
    }

    /**
     * Método para guardar los diagnósticos
     */
    public DiagModel guardarDiag(DiagModel diag){
        return diagRepository.save(diag);
    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<DiagModel> getById(Long id){
        return diagRepository.findById(id);
    }

    /**
     * Método para actualizar los diagnósticos
     */
    public DiagModel updateById(DiagModel request, Long id){
        DiagModel diag = diagRepository.findById(id).get();

        // Condicional que controla que si no se introduce el dato, este no se actualiza
        if (request.getValoracionEspecialista() == null) {} else {diag.setValoracionEspecialista(request.getValoracionEspecialista());}

        if (request.getEnfermedad() == null) {} else {diag.setEnfermedad(request.getEnfermedad());}

        diag = diagRepository.save(diag);

        return diag;
    }

    /**
     * Método para borrar el diagnóstico a través del ID
     */
    public Boolean deleteDiag(Long id){
        try{
            diagRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }

}
