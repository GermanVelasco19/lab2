package co.edu.javeriana.as.personapp.configuration;

import co.edu.javeriana.as.personapp.application.port.in.ProfesionInputPort;
import co.edu.javeriana.as.personapp.application.port.out.ProfesionOutputPort;
import co.edu.javeriana.as.personapp.application.usecase.ProfesionUseCase;
import co.edu.javeriana.as.personapp.common.exceptions.InvalidOptionException;
import co.edu.javeriana.as.personapp.common.setup.DatabaseOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfesionOutPutPortFactory {

    @Autowired
    @Qualifier("profesionOutPutAdapterMaria")
    private ProfesionOutputPort profesionOutputPortMaria;

    @Autowired
    @Qualifier("profesionOutputAdapterMongo")
    private ProfesionOutputPort profesionOutputPortMongo;

    public ProfesionInputPort getProfesionOutputPort(String dbOption) throws InvalidOptionException{
        ProfesionInputPort profesionInputPort;
        if(dbOption.equalsIgnoreCase(DatabaseOption.MARIA.toString())){
            profesionInputPort = new ProfesionUseCase(profesionOutputPortMaria);
        }else if (dbOption.equalsIgnoreCase(DatabaseOption.MONGO.toString())){
            profesionInputPort = new ProfesionUseCase(profesionOutputPortMongo);
        }else {
            throw new InvalidOptionException("Invalid database option: "+dbOption);
        }
        return profesionInputPort;
    }
}
