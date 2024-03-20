package com.example.CitasMedicas.services;

import com.example.CitasMedicas.dto.PacientDTO;
import com.example.CitasMedicas.interfaces.IPacientService;
import com.example.CitasMedicas.mapper.PacientMapper;
import com.example.CitasMedicas.models.PacientModel;
import com.example.CitasMedicas.repositories.IPacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacientService implements IPacientService {

    // Anotación para introducir dependencias
    @Autowired
    // Repositorio de los pacientes
    IPacientRepository pacientRepository;

    @Autowired
    private PacientMapper pacientMapper;

    /**
     * Método para obtener el array dónde se obtiene la lista de pacientes
     */
    public List<PacientDTO> getPacient(){
        // Devuelve todos los pacientes del repositorio
        List<PacientModel> user = pacientRepository.findAll();
        return pacientMapper.PDTOtoList(user);
    }

    /**
     * Método para guardar el pacientes
     */
    public PacientDTO guardarPaciente(PacientModel user){
        PacientModel pacientModel = pacientRepository.save(user);
        return pacientMapper.PToDto(pacientModel);
    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<PacientDTO> getById(Long id){
        PacientModel pacientModel;
        if (pacientRepository.findById(id).isPresent()) {
            pacientModel = pacientRepository.findById(id).get();
        } else {
            pacientModel = null;
        }
        PacientDTO pacientDTO = pacientMapper.PToDto(pacientModel);
        return Optional.ofNullable(pacientDTO);
    }

    /**
     * Método para actualizar el paciente
     */
    public PacientDTO updateById(PacientModel request, Long id){
        PacientModel user;
        if (pacientRepository.findById(id).isPresent()){
            user = pacientRepository.findById(id).get();
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
        } else {
            user = null;
        }
        return pacientMapper.PToDto(user);
    }

    /**
     * Método para borrar el paciente a través del ID
     */
    public Boolean deletePacient(Long id){
        boolean existe = pacientRepository.existsById(id);
        if (existe){
            try{
                pacientRepository.deleteById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        } else {
            return false;
        }

    }

}
