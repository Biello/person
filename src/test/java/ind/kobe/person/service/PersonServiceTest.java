package ind.kobe.person.service;

import ind.kobe.person.bean.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Bielu
 * @Date: Created on 16:41 2018/1/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void findOne() throws Exception {
        Person person = personService.findOne(1);
        Assert.assertEquals(36, person.getAge());
    }

}