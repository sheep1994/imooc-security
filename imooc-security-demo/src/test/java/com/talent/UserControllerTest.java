package com.talent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author guobing
 * @Title: UserControllerTest
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/1/28下午2:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    /**
     * 注入 IoC 容器
     */
    @Autowired
    private WebApplicationContext context;

    /**
     * 伪造一个 Spring Mvc 环境
     */
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        // 伪造一个 mvc 环境
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * 查询
     * @throws Exception
     */
    @Test
    public void whenQuerySuccess() throws Exception {
        // 伪造http请求
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user") // 执行GET请求
                .param("username", "张三")      // 添加参数
                .param("age", "12")
                .param("ageTo", "25")
                .param("xxx", "再议...")
                .contentType(MediaType.APPLICATION_JSON_UTF8))   // 设置content-Type
                // 对请求结果的期望
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 解析返回去的json内容
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 获取详情
     */
    @Test
    public void whenGetInfoSuccess() throws Exception {
        // 伪造http请求
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 获取详情失败
     */
    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    /**
     * 创建
     */
    @Test
    public void whenCreateSuccess() throws Exception {
        String content = "{\"username\":\"tom\",\"password\":null}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }
}
