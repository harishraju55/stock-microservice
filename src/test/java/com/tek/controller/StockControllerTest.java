package com.tek.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { StocksMicroserviceApplication.class })
@SpringBootTest
public class StockControllerTest {
	
private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	@Test
	public void verifyAllStocks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/stocks").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(print());
	}
	@Test
	public void verifyStockBySymbol() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/stocks/AAPL").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.symbol").exists())
		.andExpect(jsonPath("$.price").exists())
		.andExpect(jsonPath("$.name").value("Apple"))
		.andExpect(jsonPath("$.symbol").value("AAPL"))
		.andExpect(jsonPath("$.price").value(110.0))
		.andDo(print());
	}
}
