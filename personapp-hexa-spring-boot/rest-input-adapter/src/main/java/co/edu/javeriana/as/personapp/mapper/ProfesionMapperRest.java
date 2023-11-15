package co.edu.javeriana.as.personapp.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.model.request.ProfesionRequest;
import co.edu.javeriana.as.personapp.model.response.ProfesionResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Mapper
@Slf4j
public class ProfesionMapperRest {

    public ProfesionResponse fromDomainToAdapterRestMaria(Profession profesion){
        return fromDomainToAdapterRest(profesion,"MariaDB");
    }
    public ProfesionResponse fromDomainToAdapterRestMongo(Profession profesion){
        return fromDomainToAdapterRest(profesion,"Mongo");
    }

    public ProfesionResponse fromDomainToAdapterRest(Profession profesion,String database){
        return ProfesionResponse.builder()
                .status("OK")
                .name(profesion.getName())
                .identification(profesion.getIdentification())
                .studies(profesion.getStudies())
                .build();
    }

    public Profession fromAdapterToDomain(ProfesionRequest request, List<Study> studies){
        return new Profession(
                request.getIdentification(),
                request.getName(),
                request.getDescription(),
                studies
        );
    }
}
