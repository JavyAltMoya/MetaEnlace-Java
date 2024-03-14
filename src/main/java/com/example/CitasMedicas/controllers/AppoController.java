package com.example.CitasMedicas.controllers;

import com.example.CitasMedicas.models.AppoModel;
import com.example.CitasMedicas.models.MedicModel;
import com.example.CitasMedicas.services.AppoService;
import com.example.CitasMedicas.services.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ArrayList<AppoModel> getCita(){
        // Devolvemos la lista de citas
        return this.appoService.getCita();
    }

    // Se usa para guardar el método de las citas
    @PostMapping
    // Guardamos las citas
    public AppoModel guardarCita(@RequestBody AppoModel date){
        return this.appoService.guardarCita(date);
    }

    // Se usa para obtener el id de una cita
    @GetMapping(path= "/{id}")
    public Optional<AppoModel> getCitaByID(@PathVariable Long id){

        return this.appoService.getById(id);
    }

    // Se usa para actualizar la cita
    @PutMapping(path= "/{id}")
    public AppoModel updateCitaByID(@RequestBody AppoModel request,@PathVariable("id") Long id){
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
