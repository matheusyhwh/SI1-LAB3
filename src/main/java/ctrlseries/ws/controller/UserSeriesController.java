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
import ctrlseries.ws.model.Serie;
import ctrlseries.ws.service.UserService;
import ctrlseries.ws.service.SerieService;

@RestController
@RequestMapping("/cliente/")
public class UserSeriesController {
	
	@Autowired
	UserService userService;
	@Autowired
	SerieService serieService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "perfil/{id}", 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serie> cadastrarSerieNoPerfil(@RequestBody Serie serie, @PathVariable("id") Long id) {
		
		Serie cadastrada = serieService.cadastrarSerie(serie);
		User clienteEncontrado = userService.getClientesPorId(id);
		clienteEncontrado.addNoPerfil(cadastrada);
		userService.cadastrar(clienteEncontrado);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "watchlist/{id}", 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serie> cadastrarSerieNaWatchlist(@RequestBody Serie serie, @PathVariable("id") Long id) {
		
		Serie cadastrada = serieService.cadastrarSerie(serie);
		User clienteEncontrado = userService.getClientesPorId(id);
		clienteEncontrado.addWatchList(cadastrada);
		userService.cadastrar(clienteEncontrado);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "removerPerfil/{id}/{id2}")
	public ResponseEntity<String> deletarSeriePerfil(@PathVariable Long id, @PathVariable String id2) {
		
		User encontrado = userService.getClientesPorId(id);
		encontrado.removerSeriePerfilID(id2);
		userService.cadastrar(encontrado);
		return new ResponseEntity<>("Serie removida com sucesso", HttpStatus.OK);
		
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "removerWatchList/{id}/{id2}")
	public ResponseEntity<String> deletarSerieWatchlist(@PathVariable Long id, @PathVariable String id2) {
		
		User encontrado = userService.getClientesPorId(id);
		encontrado.removerSerieWatchlistID(id2);
		userService.cadastrar(encontrado);
		return new ResponseEntity<>("Serie removida com sucesso", HttpStatus.OK);
		
	}
	

}
