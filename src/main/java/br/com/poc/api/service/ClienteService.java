package br.com.poc.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.poc.api.entity.Cliente;
import br.com.poc.api.repository.ClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;

	@SuppressWarnings("unchecked")
	public List<Cliente> findAll(Pageable pageable) {
		List<Cliente> findAll = (List<Cliente>) clienteRepository.findAll(pageable);
		return findAll;
	}
	
	public Cliente findByName(){
		return clienteRepository.customMethod("Afonso");
	}
	
	public Cliente findByCpf(){
		return clienteRepository.findByCpf("12345678909");
	}
	
	
}
