package co.edu.javeriana.as.personapp.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.model.response.TelefonoResponse;
import lombok.extern.slf4j.Slf4j;

@Mapper
@Slf4j
public class PhoneMapperRest {
    public TelefonoResponse fromDomainToAdapterRestMaria(Phone phone) {
        return fromDomainToAdapterRest(phone, "MariaDB");
    }
    public TelefonoResponse fromDomainToAdapterRestMongo(Phone phone) {
        return fromDomainToAdapterRest(phone, "MongoDB");
    }

    public TelefonoResponse fromDomainToAdapterRest(Phone phone, String database) {
        return TelefonoResponse.builder()
                .status("OK")
                .oper(phone.getCompany())
                .num(Integer.valueOf(phone.getNumber()))
                .database(database)
                .duenio(phone.getOwner().getIdentification())
                .build();
    }

    public Phone fromAdapterToDomain(TelefonoRequest request, Person owner) {
        return new Phone(
                request.getNum().toString(),
                request.getOper(),
                owner
        );
    }
}