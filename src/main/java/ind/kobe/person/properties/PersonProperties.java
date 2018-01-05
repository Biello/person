package ind.kobe.person.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Bielu
 * @Date: Created on 23:14 2018/1/5
 */

@Component
@ConfigurationProperties(prefix = "person")
public class PersonProperties {

    private String name;

    private int age;

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
