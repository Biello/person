package ind.kobe.person.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ind.kobe.person.bean.Person;


/**
 * 使用MockMvc进行API测试
 * @Author: Bielu
 * @Date: Created on 16:43 2018/1/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

	private final static Logger logger = LoggerFactory.getLogger(PersonControllerTest.class);
	
    @Autowired
    private MockMvc mvc;

    @Test
    public void personList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/persons"))
                .andExpect(MockMvcResultMatchers.status().isOk());  //测试返回状态
//              .andExpect(MockMvcResultMatchers.content().string("abc"));  //测试返回内容
    }
    
    @Test
    public void personAdd() throws Exception {
    	Person person = new Person();
    	person.setName("xukang");
    	person.setAge(17);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/person", person))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();  //测试返回状态
//              .andExpect(MockMvcResultMatchers.content().string("abc"));  //测试返回内容
        logger.info(mvcResult.getResponse().getContentAsString());
    }

}