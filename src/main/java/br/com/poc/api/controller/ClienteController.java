package br.com.poc.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.api.controller.base.BaseController;
import br.com.poc.api.dto.ClienteDTO;
import br.com.poc.api.dto.PageDTO;
import br.com.poc.api.entity.Cliente;
import br.com.poc.api.exception.PocApiException;
import br.com.poc.api.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends BaseController{
	
	
	@Autowired
	private ClienteService clienteService;
	
	@Value("${page.size}")
	private int pageSize;

	@CrossOrigin
	@GetMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public Page<ClienteDTO> findAll(PageDTO pageDTO) throws PocApiException{
		PageRequest pageRequest = pageDTO.getPageRequest(pageSize);
		
		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		Page<ClienteDTO> clientesDTO = clientes.map(cliente -> (ClienteDTO) buildDTO(cliente, ClienteDTO.class));
		//throw new PocApiException(ApiExceptionMessage.INVALID_TOKEN);
		return clientesDTO;
		
	}
	
	@CrossOrigin
	@GetMapping(value = "/name/{name}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	
	public ClienteDTO findByNome(@PathVariable("name") String name){
		Optional<Cliente> cliente = clienteService.findByName(name);
		return (ClienteDTO) buildDTO(cliente.get(), ClienteDTO.class);
	}
	
	@CrossOrigin
	@GetMapping(value = "/cpf/{cpf}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ClienteDTO findByCpf(@PathVariable("cpf") String cpf){
		Optional<Cliente> cliente = clienteService.findByCpf(cpf);
		return (ClienteDTO) buildDTO(cliente.get(), ClienteDTO.class);
	}
	
}
