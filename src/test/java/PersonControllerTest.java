package com.goring.controller;

import com.goring.domain.Person;
import com.goring.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonControllerTest {
	@Mock
	private PersonService personService;

	@InjectMocks
	private PersonController personController;

	private MockMvc mockMvc;

	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
 
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    public void testIndex() throws Exception {
    	mockMvc.perform(get("/"))
    			.andExpect(status().isOk());
    }

    @Test
    public void testCreateNewPerson() throws Exception {
    	mockMvc.perform(get("/person/create"))
    			.andExpect(status().isOk());
    }

    @Test
    public void testEditPerson() throws Exception {
    	mockMvc.perform(get("/person/edit/{id}", "1"))
    			.andExpect(status().isOk());
    }

    @Test
    public void testSavePerson() throws Exception {
    	mockMvc.perform(post("/person/save", new Object[0])
    			.param("name", "JunitN")
    			.param("email", "Junit@email")
    			.param("password", "JunitP")
    			.param("mobile", "1234"))
    			.andExpect(redirectedUrl("index"));
    }

    @Test
    public void testUpdatePerson() throws Exception {
    	mockMvc.perform(post("/person/update", new Object[0])
    			.param("id", "1")
    			.param("name", "JunitN")
    			.param("email", "Junit@email")
    			.param("password", "JunitP")
    			.param("mobile", "1234"))
    			.andExpect(redirectedUrl("index"));
    }

    @Test
    public void testDeletePerson() throws Exception {
    	mockMvc.perform(post("/person/delete/{id}", "1"))
    			.andExpect(redirectedUrl("/person/index"));
    }
}