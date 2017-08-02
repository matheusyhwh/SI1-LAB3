package ctrlseries.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ctrlseries.ws.model.User;
import ctrlseries.ws.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User cadastrar(User user) {
		
		return userRepository.save(user);			
	}
	
	public User getClientePorEmail(User user){
		List<User> users = userRepository.findAll();
		for(User c : users) {
			if(c.getLogin().equals(user.getLogin()))
				return c;
		}
		return new User();
	}

	public User getClientesPorId(Long id) {
		
		User clienteEncontrado = userRepository.findOne(id);
		if(clienteEncontrado != null) {
			return clienteEncontrado;
		}
		return new User();
		
	}
	
	public User autenticaUser(User user) {
		User comparado = getClientePorEmail(user);
		if(comparado.getLogin() != null && comparado.getPassword().equals(user.getPassword())){
			return comparado;
		}
		return new User();
	}

	

}
