package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void addJson() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value("111"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value("1010"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("10001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "101").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }

    @Test
    public void andOperation() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "1101").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1001"));
    }

    @Test
    public void orOperation() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "1001").param("operand2", "0110"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }
}
