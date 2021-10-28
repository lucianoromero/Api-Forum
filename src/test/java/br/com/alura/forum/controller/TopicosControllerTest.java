package br.com.alura.forum.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TopicosControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testeMetodoGet() throws Exception{
    URI  uri = new URI("/topicos");
    
    mockMvc
    .perform(MockMvcRequestBuilders.get(uri))
    .andExpect(MockMvcResultMatchers
    		.status()
    		.is(200));;
	}
	
	
	@Test
	public void testeMetodoPost() throws Exception{
    URI  uri = new URI("/topicos");
    String json = "{\r\n"
    		+ "   \"titulo\":\"Duvida Postman\",\r\n"
    		+ "   \"mensagem\":\"Texto da mensagem\",\r\n"
    		+ "   \"nomeCurso\":\"Spring Boot\"\r\n"
    		+ "\r\n"
    		+ "}";
    
    mockMvc
    .perform(MockMvcRequestBuilders
    		.post(uri)
    		.content(json)
    		.contentType(MediaType.APPLICATION_JSON))
    .andExpect(MockMvcResultMatchers
    		.status()
    		.is(201));
	}

}
