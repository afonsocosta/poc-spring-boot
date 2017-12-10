package br.com.poc.api.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.poc.api.entity.Cliente;
import br.com.poc.api.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTest {
	
	@MockBean
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	private static final String CPF = "1234567890";
	
	@Before
	public void setUp() throws Exception{
		
		BDDMockito.given(this.clienteRepository.findByCpf(Mockito.anyString())).willReturn(new Cliente());
		
	}
	
	@After
	public void tearDown()throws Exception{
	}

	@Test
	public void shouldTestFindByCpf(){
		
		Optional<Cliente>  cliente = clienteService.findByCpf(CPF);
		
		assertNotNull(cliente);
	}
	
}
