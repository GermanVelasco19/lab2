package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.terminal.model.ProfesionModeloCli;

@Mapper
public class ProfesionMapperCli {
    public ProfesionModeloCli fromDomainToAdapterCli (Profession profesion){
        ProfesionModeloCli profesionModeloCli = new ProfesionModeloCli();
        profesionModeloCli.setIdentification(profesion.getIdentification());
        profesionModeloCli.setName(profesion.getName());
        profesionModeloCli.setDescription(profesion.getDescription());
        profesionModeloCli.setStudies(profesion.getStudies());
        return profesionModeloCli;
    }
}
