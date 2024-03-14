package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.UserDTO;
import com.example.CitasMedicas.models.UserModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    //Creamos un mapeo desde UserModel a UserDTO
    @Mapping( source = "id" , target =  "id")
    UserDTO UToDto (UserModel userModel); // Convertimos el objeto UserModel en un objeto UserDTO

    // Anotación para invertir el DTO a Model
    @InheritInverseConfiguration
    UserModel UToEntity(UserDTO userDTO);

    // Generar la lista del DTO automáticamente
    List<UserDTO> UDTOtoList(List<UserModel> userList);

    // Generar la lista del Model automáticamente
    List<UserModel> UtoEntityList(List<UserDTO> userDTOList);

}
