package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.yidiantong.dao.TestDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yidiantong.controller.TestController;

@RunWith(SpringRunner.class)
@SpringBootConfiguration

public class DemoApplicationTests {

	private MockMvc mvc;

	@Before
	public void befor(){
		this.mvc=MockMvcBuilders.standaloneSetup(new TestController()).build();
	}
	@Test
	public void contextLoads() throws Exception {
		RequestBuilder reg=get("/test");
		mvc.perform(reg).andExpect(status().isOk());
	}

}
