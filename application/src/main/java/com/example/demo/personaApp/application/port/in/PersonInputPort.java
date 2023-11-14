package com.example.demo.personaApp.application.port.in;

@Port
public interface PersonInputPort {

    public void setPersintence(PersonOutputPort personPersintence);

    public Person create(Person person);

    public Person edit(Integer identification, Person person) throws NoExistException;

    public Boolean drop(Integer identification) throws NoExistException;

    public List<Person> findAll();

    public Person findOne(Integer identification) throws NoExistException;

    public Integer count();

    public List<Phone> getPhones(Integer identification) throws NoExistException;

    public List<Study> getStudies(Integer identification) throws NoExistException;
}