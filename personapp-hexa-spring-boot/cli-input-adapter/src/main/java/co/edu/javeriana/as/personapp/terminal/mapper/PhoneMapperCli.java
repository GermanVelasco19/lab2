package co.edu.javeriana.as.personapp.terminal.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.terminal.model.PhoneModelCli;

@Mapper
public class PhoneMapperCli {

    public PhoneModelCli fromDomainToAdapterCli (Phone phone){
        PhoneModelCli phoneModelCli = new PhoneModelCli();
        phoneModelCli.setNum(Integer.valueOf(phone.getNumber()));
        phoneModelCli.setOper(phone.getCompany());
        phoneModelCli.setDuenio(phone.getOwner());
        return phoneModelCli;
    }
}
