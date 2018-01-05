package ind.kobe.person.controller;

import ind.kobe.person.bean.Person;
import ind.kobe.person.repo.PersonRepository;
import ind.kobe.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Bielu
 * @Date: Created on 23:13 2018/1/5
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons")
    public List<Person> personList() {
        return personRepository.findAll();
    }

    @GetMapping(value = "/person/{id}")
    public Person personGet(@PathVariable int id) {
        return personRepository.findOne(id);
    }

    @PutMapping(value = "/person/{id}")
    public Person personUpdate(@PathVariable("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("age") int age) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return personRepository.save(person);
    }

    @DeleteMapping(value = "/person/{id}")
    public void personDelete(@PathVariable("id") int id) {
        personRepository.delete(id);
    }

    @GetMapping(value = "/person/age/{age}")
    public List personGetByAge(@PathVariable("age") int age) {
        return personRepository.findByAge(age);
    }

    @GetMapping(value = "/insertTwoPerson")
    public void insertTwoPerson() {
        personService.insertTwoPerson();
    }
}
