package ind.kobe.person.repo;

import ind.kobe.person.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Bielu
 * @Date: Created on 23:17 2018/1/5
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    // 通过年龄查询
    public List<Person> findByAge(int age);
}
