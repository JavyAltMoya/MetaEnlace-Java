package com.example.CitasMedicas.services;

import com.example.CitasMedicas.dto.DiagDTO;
import com.example.CitasMedicas.dto.PacientDTO;
import com.example.CitasMedicas.interfaces.IDiagService;
import com.example.CitasMedicas.mapper.DiagMapper;
import com.example.CitasMedicas.models.DiagModel;
import com.example.CitasMedicas.models.PacientModel;
import com.example.CitasMedicas.repositories.IDiagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagService implements IDiagService {

    // Anotación para introducir dependencias
    @Autowired
    IDiagRepository diagRepository; // Repositorio de los diagnósticos

    @Autowired
    private DiagMapper diagMapper;

    /**
     * Método para obtener el array dónde se obtiene la lista de diagnósticos
     */
    public List<DiagDTO> getDiag(){
        // Devuelve todos los diagnósticos del repositorio
        List<DiagModel> user = diagRepository.findAll();
        return diagMapper.DDTOtoList(user);
    }

    /**
     * Método para guardar los diagnósticos
     */
    public DiagDTO guardarDiag(DiagModel diag){
        DiagModel diagModel = diagRepository.save(diag);
        return diagMapper.DToDto(diagModel);
    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<DiagDTO> getById(Long id){
        DiagModel diagModel;
        if (diagRepository.findById(id).isPresent()) {
            diagModel = diagRepository.findById(id).get();
        } else {
            diagModel = null;
        }
        DiagDTO diagDTO = diagMapper.DToDto(diagModel);
        return Optional.ofNullable(diagDTO);
    }

    /**
     * Método para actualizar los diagnósticos
     */
    public DiagDTO updateById(DiagModel request, Long id){
        DiagModel diag = diagRepository.findById(id).get();

        if (diagRepository.findById(id).isPresent()){
            // Condicional que controla que si no se introduce el dato, este no se actualiza
            if (request.getValoracionEspecialista() == null) {} else {diag.setValoracionEspecialista(request.getValoracionEspecialista());}

            if (request.getEnfermedad() == null) {} else {diag.setEnfermedad(request.getEnfermedad());}

            diag = diagRepository.save(diag);
        } else {
            diag = null;
        }

        return diagMapper.DToDto(diag);
    }

    /**
     * Método para borrar el diagnóstico a través del ID
     */
    public Boolean deleteDiag(Long id){
        boolean existe = diagRepository.existsById(id);
        if (existe){
            try{
                diagRepository.deleteById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        } else {
            return false;
        }
    }

}
