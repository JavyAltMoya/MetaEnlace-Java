package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.AppoDTO;
import com.example.CitasMedicas.models.AppoModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppoMapper {
    //Creamos un mapeo desde AppoModel a AppoDTO
    @Mappings({
            @Mapping( source = "id" , target =  "id"),
            @Mapping(source = "paciente.id", target = "pacienteId"),
            @Mapping(source = "medico.id", target = "medicoId"),
            @Mapping(source = "diagnostico.id", target = "diagnosticoId")
    })
    AppoDTO AToDto (AppoModel AppoModel); // Convertimos el objeto AppoModel en un objeto AppoDTO

    // Anotación para invertir el DTO a Model
    @InheritInverseConfiguration
    AppoModel AToEntity(AppoDTO appoDTO);

    // Generar la lista del DTO automáticamente
    List<AppoDTO> ADTOtoList(List<AppoModel> appoList);

    // Generar la lista del Model automáticamente
    List<AppoModel> AtoEntityList(List<AppoDTO> appoDTOList);
}
