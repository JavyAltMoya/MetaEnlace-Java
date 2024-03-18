package com.example.CitasMedicas.interfaces;

import com.example.CitasMedicas.dto.UserDTO;
import com.example.CitasMedicas.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> getUsers();
    UserModel guardarUsuario(UserModel user);
    Optional<UserModel> getById(Long id);
    UserModel updateById(UserModel request, Long id);
    Boolean deleteUser(Long id);
}
