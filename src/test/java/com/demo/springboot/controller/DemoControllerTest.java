package com.demo.springboot.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * 单元测试 spring boot junit4
 * @author zhangjiamei
 *
 * SpringJUnit4ClassRunner 与SpringRunner 区别：SpringRunner 继承了SpringJUnit4ClassRunner，没有扩展任何功能；使用前者，名字简短而已。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoControllerTest {

    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new DemoController()).build();
    }
	
	@Test
	public void test() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		Assert.assertEquals(1, 1);
	}

}
