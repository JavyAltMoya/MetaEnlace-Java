package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.PacientDTO;
import com.example.CitasMedicas.models.PacientModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T11:23:31+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class PacientMapperImpl implements PacientMapper {

    @Override
    public PacientDTO PToDto(PacientModel PacientModel) {
        if ( PacientModel == null ) {
            return null;
        }

        PacientDTO.PacientDTOBuilder pacientDTO = PacientDTO.builder();

        pacientDTO.id( PacientModel.getId() );
        pacientDTO.nss( PacientModel.getNss() );
        pacientDTO.numTarjeta( PacientModel.getNumTarjeta() );
        pacientDTO.telefono( PacientModel.getTelefono() );
        pacientDTO.direccion( PacientModel.getDireccion() );

        return pacientDTO.build();
    }

    @Override
    public PacientModel PToEntity(PacientDTO pacientDTO) {
        if ( pacientDTO == null ) {
            return null;
        }

        PacientModel.PacientModelBuilder pacientModel = PacientModel.builder();

        pacientModel.nss( pacientDTO.getNss() );
        pacientModel.numTarjeta( pacientDTO.getNumTarjeta() );
        pacientModel.telefono( pacientDTO.getTelefono() );
        pacientModel.direccion( pacientDTO.getDireccion() );

        return pacientModel.build();
    }

    @Override
    public List<PacientDTO> PDTOtoList(List<PacientModel> pacientList) {
        if ( pacientList == null ) {
            return null;
        }

        List<PacientDTO> list = new ArrayList<PacientDTO>( pacientList.size() );
        for ( PacientModel pacientModel : pacientList ) {
            list.add( PToDto( pacientModel ) );
        }

        return list;
    }

    @Override
    public List<PacientModel> PtoEntityList(List<PacientDTO> pacientDTOList) {
        if ( pacientDTOList == null ) {
            return null;
        }

        List<PacientModel> list = new ArrayList<PacientModel>( pacientDTOList.size() );
        for ( PacientDTO pacientDTO : pacientDTOList ) {
            list.add( PToEntity( pacientDTO ) );
        }

        return list;
    }
}
