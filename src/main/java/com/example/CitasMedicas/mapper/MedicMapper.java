package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.MedicDTO;
import com.example.CitasMedicas.models.MedicModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicMapper {

    //Creamos un mapeo desde MedicModel a MedicDTO
    @Mapping( source = "id" , target =  "id")
    MedicDTO MToDto (MedicModel MedicModel); // Convertimos el objeto MedicModel en un objeto MedicDTO

    // Anotación para invertir el DTO a Model
    @InheritInverseConfiguration
    MedicModel MToEntity(MedicDTO medicDTO);

    // Generar la lista del DTO automáticamente
    List<MedicDTO> MDTOtoList(List<MedicModel> medicList);

    // Generar la lista del Model automáticamente
    List<MedicModel> MtoEntityList(List<MedicDTO> medicDTOList);
}
