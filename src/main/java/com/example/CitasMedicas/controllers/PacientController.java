package com.example.CitasMedicas.controllers;

import com.example.CitasMedicas.dto.PacientDTO;
import com.example.CitasMedicas.models.PacientModel;
import com.example.CitasMedicas.services.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Paciente")
public class PacientController {

    // Anotación para introducir dependencias
    @Autowired
    private PacientService pacientService;

    // Se usa para indicar que este método obtiene las peticiones HTTP GET
    @GetMapping
    // Obtenemos la lista de Pacientes
    public List<PacientDTO> getPacient(){
        // Devolvemos la lista de pacientes de userService
        return this.pacientService.getPacient();
    }

    // Se usa para guardar el método de los pacientes
    @PostMapping
    // Guardamos el pacientes
    public PacientDTO guardarPaciente(@RequestBody PacientModel user){
        return this.pacientService.guardarPaciente(user);
    }

    // Se usa para obtener el id de un paciente
    @GetMapping(path= "/{id}")
    public Optional<PacientDTO> getPacientByID(@PathVariable Long id){

        return this.pacientService.getById(id);
    }

    // Se usa para actualizar el paciente
    @PutMapping(path= "/{id}")
    public PacientDTO updateUserByID(@RequestBody PacientModel request,@PathVariable("id") Long id){
        return this.pacientService.updateById(request, id);
    }


    // Se usa para el borrado de un paciente en específico
    @DeleteMapping(path= "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean hecho = this.pacientService.deletePacient(id);

        // Envía un mensaje si se ha conseguido borrar o no
        if(hecho){
            return "Paciente borrado correctamente!";
        } else {
            return "Error: El paciente no se ha borrado";
        }
    }
}
