package com.mobileai.dxc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.io.UnsupportedEncodingException;

import com.mobileai.dxc.controller.UserController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})

@WebAppConfiguration
public class MockControllerTest{
    protected MockMvc mockMvc;

    @Autowired
    protected UserController userController;

    @Before()
    public void setup()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();//初始化MockMvc对象

    }
    
    @Test
    public void loginTest() throws UnsupportedEncodingException, Exception{
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/login/validate").param("account", "dcxs").param("password", "fhdask"));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("——————————反馈数据："+ result);
    }
}