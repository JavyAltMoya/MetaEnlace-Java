package com.example.CitasMedicas.services;

import com.example.CitasMedicas.interfaces.IAppoService;
import com.example.CitasMedicas.models.AppoModel;
import com.example.CitasMedicas.repositories.IAppoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AppoService implements IAppoService {

    // Anotación para introducir dependencias
    @Autowired
    IAppoRepository appoRepository; // Repositorio de las citas

    /**
     * Método para obtener el array dónde se obtiene la lista de citas
     */
    public ArrayList<AppoModel> getCita(){
        // Devuelve todos las citas del repositorio
        return (ArrayList<AppoModel>) appoRepository.findAll();
    }

    /**
     * Método para guardar las citas
     */
    public AppoModel guardarCita(AppoModel date){
        return appoRepository.save(date);
    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<AppoModel> getById(Long id){
        return appoRepository.findById(id);
    }

    /**
     * Método para actualizar las citas
     */
    public AppoModel updateById(AppoModel request, Long id){
        AppoModel date = appoRepository.findById(id).get();

        // Condicional que controla que si no se introduce el dato, este no se actualiza
        if (request.getFechaHora() == null) {} else {date.setFechaHora(request.getFechaHora());}

        if (request.getMotivoCita() == null) {} else {date.setMotivoCita(request.getMotivoCita());}

        if (request.getAttribute11() == 0) {} else {date.setAttribute11(request.getAttribute11());}

        date = appoRepository.save(date);

        return date;
    }

    /**
     * Método para borrar la cita a través del ID
     */
    public Boolean deleteCita(Long id){
        try{
            appoRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }

}
