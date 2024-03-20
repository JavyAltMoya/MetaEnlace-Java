package com.example.CitasMedicas.controllers;

import com.example.CitasMedicas.dto.DiagDTO;
import com.example.CitasMedicas.models.DiagModel;
import com.example.CitasMedicas.services.DiagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Diag")
public class DiagController {

    // Anotación para introducir dependencias
    @Autowired
    private DiagService diagService;

    // Se usa para indicar que este método obtiene las peticiones HTTP GET
    @GetMapping
    // Obtenemos la lista de diagnósticos
    public List<DiagDTO> getDiag(){
        // Devolvemos la lista de diagnósticos
        return this.diagService.getDiag();
    }

    // Se usa para guardar el método de los diagnósticos
    @PostMapping
    // Guardamos los diagnósticos
    public DiagDTO guardarDiag(@RequestBody DiagModel diag){
        return this.diagService.guardarDiag(diag);
    }

    // Se usa para obtener el id de un diagnóstico
    @GetMapping(path= "/{id}")
    public Optional<DiagDTO> getDiagByID(@PathVariable Long id){

        return this.diagService.getById(id);
    }

    // Se usa para actualizar el diagnóstico
    @PutMapping(path= "/{id}")
    public DiagDTO updateDiagByID(@RequestBody DiagModel request,@PathVariable("id") Long id){
        return this.diagService.updateById(request, id);
    }

    // Se usa para el borrado de un diagnóstico en específico
    @DeleteMapping(path= "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean hecho = this.diagService.deleteDiag(id);

        // Envía un mensaje si se ha conseguido borrar o no
        if(hecho){
            return "Diagnóstico borrado correctamente!";
        } else {
            return "Error: El diagnóstico no se ha borrado";
        }
    }
}
