package com.work.firstapi.person;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/persons")
public class PersonController {

    private final  PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @PutMapping("{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person){
        return personService.updatePerson(id,person);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
