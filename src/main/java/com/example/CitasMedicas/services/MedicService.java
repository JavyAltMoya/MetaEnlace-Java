package com.example.CitasMedicas.services;

import com.example.CitasMedicas.interfaces.IMedicService;
import com.example.CitasMedicas.models.MedicModel;
import com.example.CitasMedicas.repositories.IMedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MedicService implements IMedicService {

    // Anotación para introducir dependencias
    @Autowired
    // Repositorio de los médicos
    IMedicRepository medicRepository;

    /**
     * Método para obtener el array dónde se obtiene la lista de médicos
     */
    public ArrayList<MedicModel> getMedic(){
        // Devuelve todos los médicos del repositorio
        return (ArrayList<MedicModel>) medicRepository.findAll();
    }

    /**
     * Método para guardar el médicos
     */
    public MedicModel guardarMedico(MedicModel user){
        return medicRepository.save(user);
    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<MedicModel> getById(Long id){
        return medicRepository.findById(id);
    }

    /**
     * Método para actualizar el médico
     */
    public MedicModel updateById(MedicModel request, Long id){
        MedicModel user = medicRepository.findById(id).get();

        // Condicional que controla que si no se introduce el dato, este no se actualiza
        if (request.getNombre() == null) {} else {user.setNombre(request.getNombre());}

        if (request.getApellidos() == null) {} else {user.setApellidos(request.getApellidos());}

        if (request.getUsuario() == null) {} else {user.setUsuario(request.getUsuario());}

        if (request.getClave() == null) {} else {user.setClave(request.getClave());}

        if (request.getNumColegiado() == null) {} else {user.setNumColegiado(request.getNumColegiado());}

        user = medicRepository.save(user);

        return user;
    }

    /**
     * Método para borrar el médico a través del ID
     */
    public Boolean deleteMedic(Long id){
        try{
            medicRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
