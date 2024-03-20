package com.example.CitasMedicas.services;

import com.example.CitasMedicas.dto.MedicDTO;
import com.example.CitasMedicas.dto.UserDTO;
import com.example.CitasMedicas.interfaces.IMedicService;
import com.example.CitasMedicas.mapper.MedicMapper;
import com.example.CitasMedicas.models.MedicModel;
import com.example.CitasMedicas.models.UserModel;
import com.example.CitasMedicas.repositories.IMedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicService implements IMedicService {

    // Anotación para introducir dependencias
    @Autowired
    // Repositorio de los médicos
    IMedicRepository medicRepository;

    @Autowired
    private MedicMapper medicMapper;

    /**
     * Método para obtener el array dónde se obtiene la lista de médicos
     */
    public List<MedicDTO> getMedic(){
        // Devuelve todos los médicos del repositorio
        List<MedicModel> user = medicRepository.findAll();
        return medicMapper.MDTOtoList(user);
    }

    /**
     * Método para guardar el médicos
     */
    public MedicDTO guardarMedico(MedicModel user){
        MedicModel medicModel = medicRepository.save(user);
        return medicMapper.MToDto(medicModel);
    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<MedicDTO> getById(Long id){
        MedicModel medicModel;
        if (medicRepository.findById(id).isPresent()) {
            medicModel = medicRepository.findById(id).get();
        } else {
            medicModel = null;
        }
        MedicDTO medicDTO = medicMapper.MToDto(medicModel);
        return Optional.ofNullable(medicDTO);
    }

    /**
     * Método para actualizar el médico
     */
    public MedicDTO updateById(MedicModel request, Long id){
        // Condicional que controla que si no se introduce el dato, este no se actualiza
        MedicModel user;
        if (medicRepository.findById(id).isPresent()){
            user = medicRepository.findById(id).get();
            // Condicional que controla que si no se introduce el dato, este no se actualiza
            if (request.getNombre() == null) {} else {user.setNombre(request.getNombre());}

            if (request.getApellidos() == null) {} else {user.setApellidos(request.getApellidos());}

            if (request.getUsuario() == null) {} else {user.setUsuario(request.getUsuario());}

            if (request.getClave() == null) {} else {user.setClave(request.getClave());}

            if (request.getNumColegiado() == null) {} else {user.setNumColegiado(request.getNumColegiado());}

            user = medicRepository.save(user);
        } else {
            user = null;
        }
        return medicMapper.MToDto(user);



    }

    /**
     * Método para borrar el médico a través del ID
     */
    public Boolean deleteMedic(Long id){
        boolean existe = medicRepository.existsById(id);
        if (existe){
            try{
                medicRepository.deleteById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        } else {
            return false;
        }
    }
}
