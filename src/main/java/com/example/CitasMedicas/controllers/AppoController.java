package com.example.CitasMedicas.controllers;

import com.example.CitasMedicas.dto.AppoDTO;
import com.example.CitasMedicas.models.AppoModel;
import com.example.CitasMedicas.services.AppoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cita")
public class AppoController {

    // Anotación para introducir dependencias
    @Autowired
    private AppoService appoService;

    // Se usa para indicar que este método obtiene las peticiones HTTP GET
    @GetMapping
    // Obtenemos la lista de citas
    public List<AppoDTO> getCita(){
        // Devolvemos la lista de citas
        return this.appoService.getCita();
    }

    // Se usa para guardar el método de las citas
    @PostMapping
    // Guardamos las citas
    public AppoDTO guardarCita(@RequestBody AppoDTO date){
        return this.appoService.guardarCita(date);
    }

    // Se usa para obtener el id de una cita
    @GetMapping(path= "/{id}")
    public Optional<AppoDTO> getCitaByID(@PathVariable Long id){

        return this.appoService.getById(id);
    }

    // Se usa para actualizar la cita
    @PutMapping(path= "/{id}")
    public AppoDTO updateCitaByID(@RequestBody AppoModel request,@PathVariable("id") Long id){
        return this.appoService.updateById(request, id);
    }

    // Se usa para el borrado de una cita en específico
    @DeleteMapping(path= "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean hecho = this.appoService.deleteCita(id);

        // Envía un mensaje si se ha conseguido borrar o no
        if(hecho){
            return "Cita borrada correctamente!";
        } else {
            return "Error: La cita no se ha borrado";
        }
    }

}
