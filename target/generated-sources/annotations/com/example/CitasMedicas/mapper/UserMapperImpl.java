package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.UserDTO;
import com.example.CitasMedicas.models.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T10:35:04+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO UToDto(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( userModel.getId() );
        userDTO.nombre( userModel.getNombre() );
        userDTO.apellidos( userModel.getApellidos() );
        userDTO.usuario( userModel.getUsuario() );
        userDTO.clave( userModel.getClave() );

        return userDTO.build();
    }

    @Override
    public UserModel UToEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userDTO.getId() );
        userModel.setNombre( userDTO.getNombre() );
        userModel.setApellidos( userDTO.getApellidos() );
        userModel.setUsuario( userDTO.getUsuario() );
        userModel.setClave( userDTO.getClave() );

        return userModel;
    }

    @Override
    public List<UserDTO> UDTOtoList(List<UserModel> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( UserModel userModel : userList ) {
            list.add( UToDto( userModel ) );
        }

        return list;
    }

    @Override
    public List<UserModel> UtoEntityList(List<UserDTO> userDTOList) {
        if ( userDTOList == null ) {
            return null;
        }

        List<UserModel> list = new ArrayList<UserModel>( userDTOList.size() );
        for ( UserDTO userDTO : userDTOList ) {
            list.add( UToEntity( userDTO ) );
        }

        return list;
    }
}
