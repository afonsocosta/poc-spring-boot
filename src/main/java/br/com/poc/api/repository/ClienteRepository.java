package br.com.poc.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.poc.api.entity.Cliente;

@Transactional(readOnly=true)
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryCustom{
	
	Cliente findByNome(String nome);
	
	Cliente findByCpf(String cpf);
	
}
