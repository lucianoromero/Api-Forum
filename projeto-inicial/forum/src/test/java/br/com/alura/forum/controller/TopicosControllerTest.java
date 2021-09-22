package br.com.alura.forum.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TopicosController.class)
public class TopicosControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testMetodoGet() throws Exception {
		mockMvc
		.perform(MockMvcRequestBuilders.get("/topicos"))
		.andExpect(MockMvcResultMatchers.status().isOk());
//	    .andExpect(MockMvcResultMatchers.content().toString("teste");
	}

}
