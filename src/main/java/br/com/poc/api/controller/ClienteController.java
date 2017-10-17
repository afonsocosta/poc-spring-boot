package br.com.poc.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.api.controller.base.BaseController;
import br.com.poc.api.dto.ClienteDTO;
import br.com.poc.api.entity.Cliente;
import br.com.poc.api.exception.PocApiException;
import br.com.poc.api.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends BaseController{
	
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private ClienteService clienteService;

	@CrossOrigin
	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	/*@PreAuthorize("hasAnyRole('ADMIN')")*/
	public List<ClienteDTO> findAll(@Valid @RequestBody ClienteDTO clienteDTO) throws PocApiException{
		Cliente cliente = new Cliente();
		cliente.setCpf("123456789809");
		cliente.setNome("testando");
		List<Cliente> cliens = new ArrayList<Cliente>();
		cliens.add(cliente);
		cliens.add(cliente);
		cliens.add(cliente);
		final List<ClienteDTO> result = (List<ClienteDTO>) modelMapper.map(cliens, ArrayList.class);
		//throw new PocApiException(ApiExceptionMessage.INVALID_TOKEN);
		return result;
		
	}
	
	@CrossOrigin
	@GetMapping(value = "/findByName")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ClienteDTO findByNome(){
		Cliente cliente = clienteService.findByName();
		return (ClienteDTO) buildDTO(cliente, ClienteDTO.class);
	}
	
	@CrossOrigin
	@GetMapping(value = "/findByCpf")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ClienteDTO findByCpf(){
		Cliente cliente = clienteService.findByCpf();
		return (ClienteDTO) buildDTO(cliente, ClienteDTO.class);
	}
	
}
