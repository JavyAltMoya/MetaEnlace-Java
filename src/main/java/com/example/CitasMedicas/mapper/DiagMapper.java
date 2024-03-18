package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.DiagDTO;
import com.example.CitasMedicas.models.DiagModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiagMapper {
    //Creamos un mapeo desde DiagModel a DiagDTO
    @Mapping( source = "id" , target =  "id")
    DiagDTO DToDto (DiagModel DiagModel); // Convertimos el objeto DiagModel en un objeto DiagDTO

    // Anotación para invertir el DTO a Model
    @InheritInverseConfiguration
    DiagModel DToEntity(DiagDTO diagDTO);

    // Generar la lista del DTO automáticamente
    List<DiagDTO> DDTOtoList(List<DiagModel> diagList);

    // Generar la lista del Model automáticamente
    List<DiagModel> DtoEntityList(List<DiagDTO> diagDTOList);
}
