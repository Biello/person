package ind.kobe.person.service;

import ind.kobe.person.bean.Person;
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
}
