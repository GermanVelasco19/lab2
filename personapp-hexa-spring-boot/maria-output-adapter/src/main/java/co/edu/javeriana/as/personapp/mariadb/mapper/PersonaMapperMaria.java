package co.edu.javeriana.as.personapp.mariadb.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Gender;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.mariadb.entity.EstudiosEntity;
import co.edu.javeriana.as.personapp.mariadb.entity.PersonaEntity;
import co.edu.javeriana.as.personapp.mariadb.entity.TelefonoEntity;
import lombok.NonNull;

@Mapper
public class PersonaMapperMaria {

	@Autowired
	private EstudiosMapperMaria estudiosMapperMaria;

	@Autowired
	private TelefonoMapperMaria telefonoMapperMaria;

	@Autowired
	private  ProfesionMapperMaria profesionMapperMaria;

	public PersonaEntity fromDomainToAdapter(Person person) {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setCc(person.getIdentification());
		personaEntity.setNombre(person.getFirstName());
		personaEntity.setApellido(person.getLastName());
		personaEntity.setGenero(validateGenero(person.getGender()));
		personaEntity.setEdad(validateEdad(person.getAge()));
		personaEntity.setEstudios(validateEstudios(person.getStudies()));
		personaEntity.setTelefonos(validateTelefonos(person.getPhoneNumbers()));
		return personaEntity;
	}

	private Character validateGenero(@NonNull Gender gender) {
		return gender == Gender.FEMALE ? 'F' : gender == Gender.MALE ? 'M' : ' ';
	}

	private Integer validateEdad(Integer age) {
		return age != null && age >= 0 ? age : null;
	}

	private List<TelefonoEntity> validateTelefonos(List<Phone> phoneNumbers) {
		return phoneNumbers != null && !phoneNumbers.isEmpty() ? phoneNumbers.stream()
				.map(phone -> telefonoMapperMaria.fromDomainToAdapter(phone)).collect(Collectors.toList())
				: new ArrayList<TelefonoEntity>();
	}

	public Person fromAdapterToDomain(PersonaEntity personaEntity) {
		Person person = new Person();
		person.setIdentification(personaEntity.getCc());
		person.setFirstName(personaEntity.getNombre());
		person.setLastName(personaEntity.getApellido());
		person.setGender(validateGender(personaEntity.getGenero()));
		person.setAge(validateAge(personaEntity.getEdad()));
		person.setStudies(null);
		person.setPhoneNumbers(null);
		return person;
	}

	private @NonNull Gender validateGender(Character genero) {
		return genero == 'F' ? Gender.FEMALE : genero == 'M' ? Gender.MALE : Gender.OTHER;
	}

	private Integer validateAge(Integer edad) {
		return edad != null && edad >= 0 ? edad : null;
	}


	private List<Phone> validatePhones(List<TelefonoEntity> telefonoEntities) {
		return telefonoEntities != null && !telefonoEntities.isEmpty() ? telefonoEntities.stream()
				.map(telefono -> telefonoMapperMaria.fromAdapterToDomainWithoutOwnerValidation(telefono))
				.collect(Collectors.toList())
				: new ArrayList<Phone>();
	}

	private List<EstudiosEntity> validateEstudios(List<Study> studies) {
		return convertList(studies, study -> estudiosMapperMaria.fromDomainToAdapterWithOutVerify(study));
	}



	private <T, U> List<U> convertList(List<T> sourceList, Function<T, U> converter) {
		return sourceList != null && !sourceList.isEmpty()
				? sourceList.stream().map(converter).collect(Collectors.toList())
				: new ArrayList<>();
	}

}