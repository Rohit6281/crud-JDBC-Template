package com.JDBCApi.crudJDBCTemplate.controller;

import com.JDBCApi.crudJDBCTemplate.domain.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.models.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp(){
      mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    @Description("Test for PostMethod")
    public void addUser() throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("rohit");
        user.setLastName("p");
        user.setEmail("rohit@gmail.com");
       String JsonRequest = mapper.writeValueAsString(user);
        MvcResult result = mockMvc.perform(post("/user").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContext = result.getResponse().getContentAsString();

        Response response = mapper.readValue(resultContext,Response.class);

        Assert.assertEquals(user,user);
    }
    @Test
    @Description("Testing for PutMethod")
    public void User() throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("rohit");
        user.setLastName("p");
        user.setEmail("rohit@gmail.com");
        String JsonRequest = mapper.writeValueAsString(user);
        MvcResult result = mockMvc.perform(put("/user").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
        String resultContext = result.getResponse().getContentAsString();

        Response response = mapper.readValue(resultContext,Response.class);

        Assert.assertEquals(user,user);
    }


}
