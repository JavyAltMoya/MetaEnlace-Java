package com.example.CitasMedicas.controllers;

import com.example.CitasMedicas.models.UserModel;
import com.example.CitasMedicas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
// Definimos la ruta de manera mas sencilla
@RequestMapping("/Usuario")
public class UserController {

    // Anotación para introducir dependencias
    @Autowired
    private UserService userService;

    // Se usa para indicar que este método obtiene las peticiones HTTP GET
    @GetMapping
    // Obtenemos la lista de Usuarios
    public ArrayList<UserModel> getUsers(){
        // Devolvemos la lista de usuarios de userService
        return this.userService.getUsers();
    }

    // Se usa para guardar el método de los usuarios
    @PostMapping
    // Guardamos el usuario
    public UserModel guardarUsuario(@RequestBody UserModel user){
        return this.userService.guardarUsuario(user);
    }

    // Se usa para obtener el id de un usuario
    @GetMapping(path= "/{id}")
    public Optional<UserModel> getUserByID(@PathVariable Long id){
        return this.userService.getById(id);
    }

    // Se usa para actualizar el usuario
    @PutMapping(path= "/{id}")
    public UserModel updateUserByID(@RequestBody UserModel request,@PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }

    // Se usa para el borrado de un usuario en específico
    @DeleteMapping(path= "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean hecho = this.userService.deleteUser(id);

        // Envía un mensaje si se ha conseguido borrar o no
        if(hecho){
            return "Usuario borrado correctamente!";
        } else {
            return "Error: El usuario no se ha borrado";
        }
    }
}
