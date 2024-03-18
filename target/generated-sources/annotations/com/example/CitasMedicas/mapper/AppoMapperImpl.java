package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.AppoDTO;
import com.example.CitasMedicas.models.AppoModel;
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
public class AppoMapperImpl implements AppoMapper {

    @Override
    public AppoDTO AToDto(AppoModel AppoModel) {
        if ( AppoModel == null ) {
            return null;
        }

        AppoDTO.AppoDTOBuilder appoDTO = AppoDTO.builder();

        appoDTO.id( AppoModel.getId() );
        appoDTO.fechaHora( AppoModel.getFechaHora() );
        appoDTO.motivoCita( AppoModel.getMotivoCita() );
        appoDTO.attribute11( AppoModel.getAttribute11() );

        return appoDTO.build();
    }

    @Override
    public AppoModel AToEntity(AppoDTO appoDTO) {
        if ( appoDTO == null ) {
            return null;
        }

        AppoModel.AppoModelBuilder appoModel = AppoModel.builder();

        appoModel.id( appoDTO.getId() );
        appoModel.fechaHora( appoDTO.getFechaHora() );
        appoModel.motivoCita( appoDTO.getMotivoCita() );
        appoModel.attribute11( appoDTO.getAttribute11() );

        return appoModel.build();
    }

    @Override
    public List<AppoDTO> ADTOtoList(List<AppoModel> appoList) {
        if ( appoList == null ) {
            return null;
        }

        List<AppoDTO> list = new ArrayList<AppoDTO>( appoList.size() );
        for ( AppoModel appoModel : appoList ) {
            list.add( AToDto( appoModel ) );
        }

        return list;
    }

    @Override
    public List<AppoModel> AtoEntityList(List<AppoDTO> appoDTOList) {
        if ( appoDTOList == null ) {
            return null;
        }

        List<AppoModel> list = new ArrayList<AppoModel>( appoDTOList.size() );
        for ( AppoDTO appoDTO : appoDTOList ) {
            list.add( AToEntity( appoDTO ) );
        }

        return list;
    }
}
