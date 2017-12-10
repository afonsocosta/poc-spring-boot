package br.com.poc.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.poc.api.entity.Cliente;
import br.com.poc.api.service.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ClienteService clienteService;
	
	private static final String FIND_BY_NAME_URL = "/api/cliente/name/";

	private static final Long ID = Long.valueOf(1);
	private static final String NAME = "Afonso";
	private static final String CPF = "12345678909";
	
	@Test
	@WithMockUser(username="admin@admin.com.br", roles={"ADMIN"})
	public void shouldTestFindByName() throws Exception{
		BDDMockito.given(this.clienteService.findByName(Mockito.anyString())).willReturn(Optional.of(getDadosCliente()));
		
		mvc.perform(MockMvcRequestBuilders.get(FIND_BY_NAME_URL + NAME).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(ID))
		.andExpect(jsonPath("$.nome").value(NAME))
		.andExpect(jsonPath("$.cpf").value(CPF));
	}
	
	
	private Cliente getDadosCliente(){
		Cliente cliente = new Cliente();
		cliente.setId(ID);
		cliente.setNome(NAME);
		cliente.setCpf(CPF);
		
		return cliente;
	}
}
