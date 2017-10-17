package br.com.poc.api.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.com.poc.api.repository.ClienteRepository;
import br.com.poc.api.validation.UniqueRecord;

public class ClienteDTO {

	
	
	private Long id;
	
	@NotEmpty
	@Length(min = 5, max = 10)
	private String nome;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@UniqueRecord(method = "findByNome", repository = ClienteRepository.class)
	private String teste;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	
	
	

}
