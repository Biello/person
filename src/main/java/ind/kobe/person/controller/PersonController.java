package ind.kobe.person.controller;

import ind.kobe.person.bean.Person;
import ind.kobe.person.repo.PersonRepository;
import ind.kobe.person.service.PersonService;
import ind.kobe.person.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Bielu
 * @Date: Created on 23:13 2018/1/5
 */
@RestController
public class PersonController {

    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

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

    @PostMapping(value = "/person")
    public Object personAdd(@Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            logger.info(msg);
            return ResultUtil.error(1, msg);
        }
        person.setName(person.getName());
        person.setAge(person.getAge());
        return ResultUtil.success(personRepository.save(person));
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
    public List<Person> personGetByAge(@PathVariable("age") int age) {
        return personRepository.findByAge(age);
    }

    @GetMapping(value = "/insertTwoPerson")
    public void insertTwoPerson() {
        personService.insertTwoPerson();
    }

    @GetMapping(value = "person/getAge/{id}")
    public int getAgeById(@PathVariable("id") int id) throws Exception{
        return personService.getAge(id);
    }

}
