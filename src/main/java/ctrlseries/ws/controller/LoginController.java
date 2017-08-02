package ctrlseries.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ctrlseries.ws.model.Cliente;
import ctrlseries.ws.service.ClienteService;

@RestController
public class LoginController {
	
	@Autowired
	ClienteService clienteService;

	@RequestMapping(method = RequestMethod.POST, value = "/clientes/autenticar", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> autenticarCliente(@RequestBody Cliente cliente) {
		
		return new ResponseEntity<>(clienteService.autenticaUser(cliente), HttpStatus.OK);

	}
	
}
