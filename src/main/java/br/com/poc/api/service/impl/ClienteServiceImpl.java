package br.com.poc.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.poc.api.entity.Cliente;
import br.com.poc.api.repository.ClienteRepository;
import br.com.poc.api.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private Logger logger =  LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		Page<Cliente> clientes =  clienteRepository.findAll(pageable);
		return clientes;
	}
	
	@Override
	public Optional<Cliente>  findByName(String name){
		logger.info("Buscando um cliene pelo nome {}",name);
		return Optional.ofNullable(clienteRepository.customMethod(name));
	}
	
	@Override
	public Optional<Cliente>  findByCpf(String cpf){
		return Optional.ofNullable(clienteRepository.findByCpf(cpf));
	}
	
	
}
