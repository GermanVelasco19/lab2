package co.edu.javeriana.as.personapp.mongo.adapter;

import co.edu.javeriana.as.personapp.application.port.out.ProfesionOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument;
import co.edu.javeriana.as.personapp.mongo.mapper.ProfesionMapperMongo;
import co.edu.javeriana.as.personapp.mongo.repository.ProfesionRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Adapter("profesionOutputAdapterMongo")
public class ProfesionOutputAdapterMongo implements ProfesionOutputPort {

    @Autowired
    private ProfesionRepositoryMongo profesionRepositoryMongo;

    @Autowired
    private ProfesionMapperMongo profesionMapperMongo;

    @Override
    public Profession save(Profession profession) {
        ProfesionDocument profesionDocument = profesionRepositoryMongo.save(profesionMapperMongo.fromDomainToAdapter(profession));
        return profesionMapperMongo.fromAdapterToDomain(profesionDocument);
    }

    @Override
    public Boolean delete(Integer identification) {
        profesionRepositoryMongo.deleteById(identification);
        return profesionRepositoryMongo.findById(identification).isEmpty();
    }

    @Override
    public List<Profession> find() {
        return profesionRepositoryMongo.findAll().stream().map(profesionMapperMongo::fromAdapterToDomain).collect(Collectors.toList());
    }

    @Override
    public Profession findById(Integer identification) {
        Optional<ProfesionDocument> profesionDocument= profesionRepositoryMongo.findById(identification);
        return profesionDocument.map(profesionDocument1 -> profesionMapperMongo.fromAdapterToDomain(profesionDocument1)).orElse(null);
    }
}
