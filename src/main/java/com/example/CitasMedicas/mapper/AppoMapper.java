package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.AppoDTO;
import com.example.CitasMedicas.models.AppoModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppoMapper {
    //Creamos un mapeo desde AppoModel a AppoDTO
    @Mapping( source = "id" , target =  "id")
    AppoDTO AToDto (AppoModel AppoModel); // Convertimos el objeto AppoModel en un objeto AppoDTO

    // Anotación para invertir el DTO a Model
    @InheritInverseConfiguration
    AppoModel AToEntity(AppoDTO appoDTO);

    // Generar la lista del DTO automáticamente
    List<AppoDTO> ADTOtoList(List<AppoModel> appoList);

    // Generar la lista del Model automáticamente
    List<AppoModel> AtoEntityList(List<AppoDTO> appoDTOList);
}
