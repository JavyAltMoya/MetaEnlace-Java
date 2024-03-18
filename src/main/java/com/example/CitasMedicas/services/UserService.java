package com.example.CitasMedicas.services;

import com.example.CitasMedicas.dto.UserDTO;
import com.example.CitasMedicas.interfaces.IUserService;
import com.example.CitasMedicas.mapper.UserMapper;
import com.example.CitasMedicas.models.UserModel;
import com.example.CitasMedicas.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    // Anotación para introducir dependencias
    @Autowired
    // Repositorio de los usuarios
    IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper; // Variable para usar el mapper

    /**
     * Método para obtener el array dónde se obtiene la lista de usuarios
     */
    public List<UserDTO> getUsers(){
        List<UserModel> user = userRepository.findAll();
        // Devuelve todos los usuarios del repositorio
        return userMapper.UDTOtoList(user);
    }

    /**
     * Método para guardar el usuario
     */
    public UserModel guardarUsuario(UserModel user){
        return userRepository.save(user);
    }

    /**
     * Método para obtener los datos a través de un ID
     */
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    /**
     * Método para actualizar el usuario
     */
    public UserModel updateById(UserModel request, Long id){
        UserModel user = userRepository.findById(id).get();

        // Condicional que controla que si no se introduce el dato, este no se actualiza
        if (request.getNombre() == null) {} else {user.setNombre(request.getNombre());}

        if (request.getApellidos() == null) {} else {user.setApellidos(request.getApellidos());}

        if (request.getUsuario() == null) {} else {user.setUsuario(request.getUsuario());}

        if (request.getClave() == null) {} else {user.setClave(request.getClave());}

        user = userRepository.save(user);

        return user;
    }

    /**
     * Método para borrar el usuario a través del ID
     */
    public Boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
