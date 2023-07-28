package com.work.firstapi.person;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person person) {
        var dbPerson = personRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Person \"" + id + "\" does not exists."));

        if (person.getName() != null && person.getName().length() > 0 && !Objects.equals(person.getName(), dbPerson.getName())) {
            dbPerson.setName(person.getName());
        }

        if (person.getSurname() != null && person.getSurname().length() > 0 && !Objects.equals(person.getSurname(), dbPerson.getSurname())) {
            dbPerson.setSurname(person.getSurname());
        }

        if (person.getEmail() != null && person.getEmail().length() > 0 && !Objects.equals(person.getEmail(), dbPerson.getEmail())) {
            dbPerson.setEmail(person.getEmail());
        }

        if (person.getBirthdate() != null && LocalDate.MIN.isAfter(person.getBirthdate()) && !Objects.equals(person.getBirthdate(), dbPerson.getBirthdate())) {
            dbPerson.setBirthdate(person.getBirthdate());
        }

        if (!Objects.equals(person.isActive(), dbPerson.isActive())) {
            dbPerson.setActive(person.isActive());
        }

        return personRepository.save(dbPerson);
    }

    public void deletePerson(Long id) {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Person \"" + id + "\" does not  exists."));

        personRepository.delete(person);
    }
}
