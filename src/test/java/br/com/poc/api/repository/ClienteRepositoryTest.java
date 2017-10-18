package br.com.poc.api.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.poc.api.entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {
	
	private static final String CPF = "1234567890";

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Before
	public void setUp() throws Exception{
		
		for (int i = 0; i < 10; i++) {
			Cliente cliente = new Cliente();
			cliente.setNome("Teste do Silva");
			cliente.setCpf(CPF+i);
			clienteRepository.save(cliente);
		}
	}
	
	@After
	public void tearDown()throws Exception{
		clienteRepository.deleteAll();
	}
	
	@Test
	public void shouldFindByCPF(){
		Cliente cliente = clienteRepository.findByCpf(CPF+"0");
		assertEquals(CPF+"0", cliente.getCpf());
	}
	
	@Test
	public void shouldFindAll(){
		List<Cliente> clientes = clienteRepository.findAll();
		assertEquals(10, clientes.size());
	}
	
	@Test
	public void shouldFindAllPageble(){
		PageRequest page = new PageRequest(0, 5);
		Page<Cliente> clientes = clienteRepository.findAll(page);
		assertEquals(5, clientes.getContent().size());
	}
}
