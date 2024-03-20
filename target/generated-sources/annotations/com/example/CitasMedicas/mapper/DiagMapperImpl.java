package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.DiagDTO;
import com.example.CitasMedicas.models.AppoModel;
import com.example.CitasMedicas.models.DiagModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T11:34:19+0100",
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
        diagDTO.citaId( diagModelCitaId( DiagModel ) );
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

        diagModel.cita( diagDTOToAppoModel( diagDTO ) );
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

    private Long diagModelCitaId(DiagModel diagModel) {
        if ( diagModel == null ) {
            return null;
        }
        AppoModel cita = diagModel.getCita();
        if ( cita == null ) {
            return null;
        }
        Long id = cita.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected AppoModel diagDTOToAppoModel(DiagDTO diagDTO) {
        if ( diagDTO == null ) {
            return null;
        }

        AppoModel.AppoModelBuilder appoModel = AppoModel.builder();

        appoModel.id( diagDTO.getCitaId() );

        return appoModel.build();
    }
}
