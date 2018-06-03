package com.jsoft.framework.ssm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 使用Mock模拟请求Web MVC
 *
 * @author jim
 * @date 2018/06/03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/spring-mvc.xml", "classpath*:spring/spring-base.xml"})
public class MockMvcTest {

    private static final Logger log = LoggerFactory.getLogger(MockMvcTest.class);

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void before() {
        // 初始化Mock，全部Controller
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        // 单个Controller
        // mockMvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

    @Test
    public void testGetTest() {
        try {
            ResultActions perform = mockMvc.perform(get("/hello"));
            log.info("status:{}", status().isOk());
            log.info("content:{}", content().toString());
            perform.andExpect(status().isOk());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
