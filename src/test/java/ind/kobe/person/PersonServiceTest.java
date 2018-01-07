package ind.kobe.person;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ind.kobe.person.bean.Person;
import ind.kobe.person.service.PersonService;

/**
 * 
 * @author Kobe Biello
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
	
	@Autowired
	private PersonService personService;
	
	@Test
	public void findOneTest() {
		Person person = personService.findOne(1);
		Assert.assertEquals(36, person.getAge());
	}

}
