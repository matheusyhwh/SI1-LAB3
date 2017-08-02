package ctrlseries.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ctrlseries.ws.model.User;
import ctrlseries.ws.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// End points

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> cadastrarCliente(@RequestBody User user) {
		
		User clienteCadastrado = userService.cadastrar(user);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);			

	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getClientById(@PathVariable Long id) {
		
		if(userService.getClientesPorId(id).getNome() != null) {
			return new ResponseEntity<>(userService.getClientesPorId(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}