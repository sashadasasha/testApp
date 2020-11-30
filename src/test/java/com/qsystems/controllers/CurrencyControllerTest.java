package com.qsystems.controllers;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by Kornyukhina Sasha
 */


public class CurrencyControllerTest extends AbstractIntegrationTest {
    @Test
    public void returnStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")) // request_mapping_path это наш URL по которому доступен REST API
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void returnInfo() throws Exception {
        String testJson = "{\"id\":\"3\",\"date\":\"2020-09-04T21:00:00.000Z\"}";
        mockMvc.perform(MockMvcRequestBuilders
                .post("/currentDate")
                .content(testJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.currentDate").value("2020-09-04"))
                .andExpect(jsonPath("$.currentValue").value(55.1671))
                .andExpect(jsonPath("$.dayBeforeDate").value("2020-09-03"))
                .andExpect(jsonPath("$.dayBeforeValue").value(54.2419))
                .andExpect(jsonPath("$.twoDaysBeforeDate").value("2020-09-02"))
                .andExpect(jsonPath("$.twoDaysBeforeValue").value(54.4381))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}