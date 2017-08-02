package ctrlseries.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ctrlseries.objects.Serie;
import ctrlseries.repositories.SerieRepository;

@Service
public class SerieService {
	
	@Autowired
	SerieRepository serieRepository;
	
	public Serie cadastrarSerie(Serie serie) {
		
		return serieRepository.save(serie);
		
	}
	
	public Serie getSerie(long id) {
		
		if(serieRepository.exists(id)) {
			return serieRepository.findOne(id);
		}
		return new Serie();
		
	}
	
	public boolean removerSerie(long id) {
		
		if(serieRepository.exists(id)) {
			serieRepository.delete(id);
			return true;
		}
		return false;
	}

}
