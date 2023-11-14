package com.example.demo.personaApp.application.port.out;

@Port
public interface PersonOutputPort {
    public Person save(Person person);
    public Boolean delete(Integer identification);
    public List<Person> find();
    public Person findById(Integer identification);
}
