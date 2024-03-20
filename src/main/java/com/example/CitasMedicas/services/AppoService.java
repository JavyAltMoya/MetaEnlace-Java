package com.example.CitasMedicas.services;

import com.example.CitasMedicas.dto.AppoDTO;
import com.example.CitasMedicas.interfaces.IAppoService;
import com.example.CitasMedicas.mapper.AppoMapper;
import com.example.CitasMedicas.models.AppoModel;
import com.example.CitasMedicas.models.DiagModel;
import com.example.CitasMedicas.models.MedicModel;
import com.example.CitasMedicas.models.PacientModel;
import com.example.CitasMedicas.repositories.IAppoRepository;
import com.example.CitasMedicas.repositories.IDiagRepository;
import com.example.CitasMedicas.repositories.IMedicRepository;
import com.example.CitasMedicas.repositories.IPacientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppoService implements IAppoService {

    // Anotación para introducir dependencias
    @Autowired
    IAppoRepository appoRepository; // Repositorio de las citas

    @Autowired
    AppoMapper appoMapper;

    @Autowired
    private IMedicRepository medicRepository;
    @Autowired
    private IPacientRepository pacientRepository;

    @Autowired
    private IDiagRepository diagRepository;

    /**
     * Método para obtener el array dónde se obtiene la lista de citas
     */
    public List<AppoDTO> getCita(){
        // Devuelve todos las citas del repositorio
        List<AppoModel> user = appoRepository.findAll();
        return appoMapper.ADTOtoList(user);
    }

    /**
     * Método para guardar las citas
     */
    public AppoDTO guardarCita(AppoDTO date){
        AppoModel appoModel = appoMapper.AToEntity(date);

        // Controlamos que el ID del médico ya existe
        Long medicoID = date.getMedicoId();
        Optional<MedicModel> medicOp = medicRepository.findById(medicoID);

        // Controlamos que el ID del paciente ya existe
        Long pacienteID = date.getPacienteId();
        Optional<PacientModel> pacientOp = pacientRepository.findById(pacienteID);

        // Controlamos que el ID del diagnóstico ya existe
        Long diagID = date.getDiagnosticoId();
        Optional<DiagModel> diagOp = diagRepository.findById(diagID);

        // Si se han introducido valores existentes introducido los datos dentro de Citas
        if (medicOp.isPresent() && pacientOp.isPresent() && diagOp.isPresent()) {
            MedicModel medicModel = medicOp.get();
            appoModel.setMedico(medicModel);

            PacientModel pacientModel = pacientOp.get();
            appoModel.setPaciente(pacientModel);

            DiagModel diagModel = diagOp.get();
            appoModel.setDiagnostico(diagModel);

            return appoMapper.AToDto(appoRepository.save(appoModel));
        } else {
            throw new EntityNotFoundException("No se pudo encontrar los datos.");
        }

    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<AppoDTO> getById(Long id){
        AppoModel appoModel;
        if (appoRepository.findById(id).isPresent()) {
            appoModel = appoRepository.findById(id).get();
        } else {
            appoModel = null;
        }
        AppoDTO appoDTO = appoMapper.AToDto(appoModel);
        return Optional.ofNullable(appoDTO);
    }

    /**
     * Método para actualizar las citas
     */
    public AppoDTO updateById(AppoModel request, Long id){
        AppoModel date;

        if (appoRepository.findById(id).isPresent()){
            date = appoRepository.findById(id).get();
            // Condicional que controla que si no se introduce el dato, este no se actualiza
            if (request.getFechaHora() == null) {} else {date.setFechaHora(request.getFechaHora());}

            if (request.getMotivoCita() == null) {} else {date.setMotivoCita(request.getMotivoCita());}

            if (request.getAttribute11() == 0) {} else {date.setAttribute11(request.getAttribute11());}

            date = appoRepository.save(date);
        } else {
            date = null;
        }

        return appoMapper.AToDto(date);
    }

    /**
     * Método para borrar la cita a través del ID
     */
    public Boolean deleteCita(Long id){
        boolean existe = appoRepository.existsById(id);
        if (existe){
            try{
                appoRepository.deleteById(id);
                return true;
            } catch(Exception e){
                return false;
            }
        } else {
            return false;
        }
    }

}
