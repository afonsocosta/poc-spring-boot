package br.com.poc.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.poc.api.security.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);
	
}
