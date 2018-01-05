package ind.kobe.person.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: Bielu
 * @Date: Created on 23:08 2018/1/5
 */

// Entity注解会自动创建一个叫person的表
@Entity
public class Person {

    //主键id,自增的
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int age;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
