package com.example.CitasMedicas.controllers;

import com.example.CitasMedicas.dto.MedicDTO;
import com.example.CitasMedicas.models.MedicModel;
import com.example.CitasMedicas.services.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Medico")
public class MedicController {

    // Anotación para introducir dependencias
    @Autowired
    private MedicService medicService;

    // Se usa para indicar que este método obtiene las peticiones HTTP GET
    @GetMapping
    // Obtenemos la lista de Médicos
    public List<MedicDTO> getMedic(){
        // Devolvemos la lista de médicos de userService
        return this.medicService.getMedic();
    }

    // Se usa para guardar el método de los médico
    @PostMapping
    // Guardamos el médicos
    public MedicDTO guardarMedico(@RequestBody MedicModel user){
        return this.medicService.guardarMedico(user);
    }

    // Se usa para obtener el id de un médico
    @GetMapping(path= "/{id}")
    public Optional<MedicDTO> getMedicByID(@PathVariable Long id){

        return this.medicService.getById(id);
    }

    // Se usa para actualizar el médico
    @PutMapping(path= "/{id}")
    public MedicDTO updateUserByID(@RequestBody MedicModel request,@PathVariable("id") Long id){
        return this.medicService.updateById(request, id);
    }

    // Se usa para el borrado de un médico en específico
    @DeleteMapping(path= "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean hecho = this.medicService.deleteMedic(id);

        // Envía un mensaje si se ha conseguido borrar o no
        if(hecho){
            return "Médico borrado correctamente!";
        } else {
            return "Error: El médico no se ha borrado";
        }
    }
}
