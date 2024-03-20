package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.dto.UserDTO;
import com.example.CitasMedicas.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> getUsers();
    UserDTO guardarUsuario(UserModel user);
    Optional<UserDTO> getById(Long id);
    UserDTO updateById(UserModel request, Long id);
    Boolean deleteUser(Long id);
}
