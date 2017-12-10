package br.com.poc.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.poc.api.entity.Cliente;

public interface ClienteService {

	
	/**
	 * Retorna uma lista paginada de todos os clientes
	 * 
	 * @param pageable
	 * @return List<Cliente>
	 */
	Page<Cliente> findAll(Pageable pageable);

	/**
	 * Retorna um cliente por nome
	 * 
	 * @param name
	 * @return Optional<Cliente> 
	 */
	Optional<Cliente> findByName(String name);

	/**
	 * Retorna um cliente por cpf
	 * 
	 * @param cpf
	 * @return Optional<Cliente> 
	 */
	Optional<Cliente> findByCpf(String cpf);

}