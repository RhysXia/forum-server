package site.rhys.forum.service.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import site.rhys.forum.service.user.api.model.User;
import site.rhys.forum.service.user.api.model.UserStatus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Rhys Xia<xrs4433@outlook.com>
 * @version 1.0.0
 * @date 2018/05/14 22:19
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext


    @Autowired
    private ObjectMapper objectMapper;

//    @Autowired
//    private MockHttpSession session;// 注入模拟的http session
//
//    @Autowired
//    private MockHttpServletRequest request;// 注入模拟的http request\

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void findById() throws Exception {
        MvcResult result = mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void findByPage() throws Exception {
        MvcResult result = mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setNickname("test");
        user.setStatus(UserStatus.ACTIVATED);
        MvcResult result = mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
//                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void updateById() {
    }
}