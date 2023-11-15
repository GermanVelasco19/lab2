package co.edu.javeriana.as.personapp.terminal.adapter;

import co.edu.javeriana.as.personapp.application.port.in.ProfesionInputPort;
import co.edu.javeriana.as.personapp.application.port.out.ProfesionOutputPort;
import co.edu.javeriana.as.personapp.application.usecase.ProfesionUseCase;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.common.exceptions.InvalidOptionException;
import co.edu.javeriana.as.personapp.common.setup.DatabaseOption;
import co.edu.javeriana.as.personapp.terminal.mapper.ProfesionMapperCli;
import co.edu.javeriana.as.personapp.terminal.model.ProfesionModeloCli;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Adapter
public class ProfesionInputAdapterCli {

    @Autowired
    @Qualifier("profesionOutPutAdapterMaria")
    private ProfesionOutputPort profesionOutputPortMaria;

    @Autowired
    @Qualifier("profesionOutputAdapterMongo")
    private ProfesionOutputPort profesionOutputPortMongo;

    @Autowired
    private ProfesionMapperCli profesionMapperCli;

    ProfesionInputPort profesionInputPort;

    public void setProfesionOutputPortInjection(String dbOption) throws InvalidOptionException{
        if(dbOption.equalsIgnoreCase(DatabaseOption.MARIA.toString())){
            profesionInputPort = new ProfesionUseCase(profesionOutputPortMaria);
        }else if(dbOption.equalsIgnoreCase(DatabaseOption.MONGO.toString())){
            profesionInputPort = new ProfesionUseCase(profesionOutputPortMongo);
        }else {
            throw new InvalidOptionException("Invalid database option: "+dbOption);
        }
    }

    public void historial(){
        log.info("Into historial ProfesionEntity in Input Adapter");
        profesionInputPort.findAll().stream()
                .map(profesionMapperCli::fromDomainToAdapterCli)
                .forEach(System.out::println);
    }

    public void historial1(){
        log.info("Into historial profesionEntity in Input Adapter");
        List<ProfesionModeloCli> profesion = profesionInputPort.findAll().stream()
                .map(profesionMapperCli::fromDomainToAdapterCli)
                .collect(Collectors.toList());
        profesion.forEach(p->System.out.println(p.toString()));
    }
}
