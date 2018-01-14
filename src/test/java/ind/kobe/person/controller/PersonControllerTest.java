package ind.kobe.person.controller;

import org.apache.catalina.util.URLEncoder;
import org.json.JSONObject;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;


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
    public void testPersonList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/persons"))
                .andExpect(MockMvcResultMatchers.status().isOk());  //测试返回状态
//              .andExpect(MockMvcResultMatchers.content().string("abc"));  //测试返回内容
    }

    @Test
    public void testPersonAdd() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/person")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .param("name", "xukang").param("age", "18"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();  //测试返回状态
//              .andExpect(MockMvcResultMatchers.content().string("abc"));  //测试返回内容
        logger.info(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void testPersonAddJson() throws Exception {
        JSONObject content = new JSONObject();
        content.put("name", "xukang").put("age", 17);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/personJson")
                .header("Content-Type", "application/json").content(content.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();  //测试返回状态
//              .andExpect(MockMvcResultMatchers.content().string("abc"));  //测试返回内容
        logger.info(mvcResult.getResponse().getContentAsString());
    }

}