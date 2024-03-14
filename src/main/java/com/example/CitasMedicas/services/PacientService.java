package com.example.CitasMedicas.services;

import com.example.CitasMedicas.interfaces.IPacientService;
import com.example.CitasMedicas.models.PacientModel;
import com.example.CitasMedicas.repositories.IPacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PacientService implements IPacientService {

    // Anotación para introducir dependencias
    @Autowired
    // Repositorio de los pacientes
    IPacientRepository pacientRepository;

    /**
     * Método para obtener el array dónde se obtiene la lista de pacientes
     */
    public ArrayList<PacientModel> getPacient(){
        // Devuelve todos los pacientes del repositorio
        return (ArrayList<PacientModel>) pacientRepository.findAll();
    }

    /**
     * Método para guardar el pacientes
     */
    public PacientModel guardarPaciente(PacientModel user){
        return pacientRepository.save(user);
    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<PacientModel> getById(Long id){
        return pacientRepository.findById(id);
    }

    /**
     * Método para actualizar el paciente
     */
    public PacientModel updateById(PacientModel request, Long id){
        PacientModel user = pacientRepository.findById(id).get();

        // Condicional que controla que si no se introduce el dato, este no se actualiza
        if (request.getNombre() == null) {} else {user.setNombre(request.getNombre());}

        if (request.getApellidos() == null) {} else {user.setApellidos(request.getApellidos());}

        if (request.getUsuario() == null) {} else {user.setUsuario(request.getUsuario());}

        if (request.getClave() == null) {} else {user.setClave(request.getClave());}

        if (request.getNss() == null) {} else {user.setNss(request.getNss());}

        if (request.getNumTarjeta() == null) {} else {user.setNumTarjeta(request.getNumTarjeta());}

        if (request.getTelefono() == null) {} else {user.setTelefono(request.getTelefono());}

        if (request.getTelefono() == null) {} else {user.setDireccion(request.getDireccion());}

        user = pacientRepository.save(user);

        return user;
    }

    /**
     * Método para borrar el paciente a través del ID
     */
    public Boolean deletePacient(Long id){
        try{
            pacientRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }

}
