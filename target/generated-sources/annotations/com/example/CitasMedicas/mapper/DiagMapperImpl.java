package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.DiagDTO;
import com.example.CitasMedicas.models.DiagModel;
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
public class DiagMapperImpl implements DiagMapper {

    @Override
    public DiagDTO DToDto(DiagModel DiagModel) {
        if ( DiagModel == null ) {
            return null;
        }

        DiagDTO.DiagDTOBuilder diagDTO = DiagDTO.builder();

        diagDTO.id( DiagModel.getId() );
        diagDTO.valoracionEspecialista( DiagModel.getValoracionEspecialista() );
        diagDTO.enfermedad( DiagModel.getEnfermedad() );

        return diagDTO.build();
    }

    @Override
    public DiagModel DToEntity(DiagDTO diagDTO) {
        if ( diagDTO == null ) {
            return null;
        }

        DiagModel.DiagModelBuilder diagModel = DiagModel.builder();

        diagModel.id( diagDTO.getId() );
        diagModel.valoracionEspecialista( diagDTO.getValoracionEspecialista() );
        diagModel.enfermedad( diagDTO.getEnfermedad() );

        return diagModel.build();
    }

    @Override
    public List<DiagDTO> DDTOtoList(List<DiagModel> diagList) {
        if ( diagList == null ) {
            return null;
        }

        List<DiagDTO> list = new ArrayList<DiagDTO>( diagList.size() );
        for ( DiagModel diagModel : diagList ) {
            list.add( DToDto( diagModel ) );
        }

        return list;
    }

    @Override
    public List<DiagModel> DtoEntityList(List<DiagDTO> diagDTOList) {
        if ( diagDTOList == null ) {
            return null;
        }

        List<DiagModel> list = new ArrayList<DiagModel>( diagDTOList.size() );
        for ( DiagDTO diagDTO : diagDTOList ) {
            list.add( DToEntity( diagDTO ) );
        }

        return list;
    }
}
