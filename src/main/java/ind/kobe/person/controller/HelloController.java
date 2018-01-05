package ind.kobe.person.controller;

import ind.kobe.person.properties.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private PersonProperties personProperties;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return content + personProperties.getName();
    }

    @RequestMapping(value = "/hi/{id}", method = RequestMethod.GET)
    public String hi(@PathVariable("id") int id) {
        return "hello " + id;
    }

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String hi2(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        return "hello " + id;
    }

    // @GetMapping() 等效于 @RequestMapping(method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String hi() {
        return "say hello";
    }
}
