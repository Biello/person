package ind.kobe.person.service;

import ind.kobe.person.bean.Person;
import ind.kobe.person.enums.ResultCodeEnum;
import ind.kobe.person.exception.PersonException;
import ind.kobe.person.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: Bielu
 * @Date: Created on 23:21 2018/1/5
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // 此方法作为一个事务
    @Transactional
    public void insertTwoPerson() {
        Person personA = new Person();
        personA.setName("Stark");
        personA.setAge(36);
        personRepository.save(personA);

        Person personB = new Person();
        personB.setName("Thor");
        personB.setAge(2000);
        personRepository.save(personB);

    }

    public int getAge(int id) throws Exception {
        Person person = personRepository.findOne(id);
        int age = person.getAge();
        if(age < 6) {
            throw new PersonException(ResultCodeEnum.PRESCHOOL_AGE);
        }else if(age >=6 && age < 12) {
            throw new PersonException(ResultCodeEnum.PRIMARY_SCHOOL);
        }else {
            return age;
        }
    }
    
    public Person findOne(int id){
        Person person = personRepository.findOne(id);
        return person;
        
    }
}
