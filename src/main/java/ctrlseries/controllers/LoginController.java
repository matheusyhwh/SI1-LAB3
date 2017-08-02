package ctrlseries.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ctrlseries.objects.User;
import ctrlseries.services.UserService;

@RestController
public class LoginController {
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/clientes/autenticar", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> autenticarCliente(@RequestBody User user) {
		
		return new ResponseEntity<>(userService.autenticaUser(user), HttpStatus.OK);

	}
	
}
