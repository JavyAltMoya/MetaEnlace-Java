package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.PacientDTO;
import com.example.CitasMedicas.models.PacientModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PacientMapper {
    //Creamos un mapeo desde PacientModel a PacientDTO
    @Mapping( source = "id" , target =  "id")
    PacientDTO PToDto (PacientModel PacientModel); // Convertimos el objeto PacientModel en un objeto PacientDTO

    // Anotación para invertir el DTO a Model
    @InheritInverseConfiguration
    PacientModel PToEntity(PacientDTO pacientDTO);

    // Generar la lista del DTO automáticamente
    List<PacientDTO> PDTOtoList(List<PacientModel> pacientList);

    // Generar la lista del Model automáticamente
    List<PacientModel> PtoEntityList(List<PacientDTO> pacientDTOList);
}
