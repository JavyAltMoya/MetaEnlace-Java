package com.example.CitasMedicas.mapper;

import com.example.CitasMedicas.dto.MedicDTO;
import com.example.CitasMedicas.models.MedicModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T11:10:41+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class MedicMapperImpl implements MedicMapper {

    @Override
    public MedicDTO MToDto(MedicModel MedicModel) {
        if ( MedicModel == null ) {
            return null;
        }

        MedicDTO.MedicDTOBuilder medicDTO = MedicDTO.builder();

        medicDTO.id( MedicModel.getId() );
        medicDTO.numColegiado( MedicModel.getNumColegiado() );

        return medicDTO.build();
    }

    @Override
    public MedicModel MToEntity(MedicDTO medicDTO) {
        if ( medicDTO == null ) {
            return null;
        }

        MedicModel.MedicModelBuilder medicModel = MedicModel.builder();

        medicModel.numColegiado( medicDTO.getNumColegiado() );

        return medicModel.build();
    }

    @Override
    public List<MedicDTO> MDTOtoList(List<MedicModel> medicList) {
        if ( medicList == null ) {
            return null;
        }

        List<MedicDTO> list = new ArrayList<MedicDTO>( medicList.size() );
        for ( MedicModel medicModel : medicList ) {
            list.add( MToDto( medicModel ) );
        }

        return list;
    }

    @Override
    public List<MedicModel> MtoEntityList(List<MedicDTO> medicDTOList) {
        if ( medicDTOList == null ) {
            return null;
        }

        List<MedicModel> list = new ArrayList<MedicModel>( medicDTOList.size() );
        for ( MedicDTO medicDTO : medicDTOList ) {
            list.add( MToEntity( medicDTO ) );
        }

        return list;
    }
}
