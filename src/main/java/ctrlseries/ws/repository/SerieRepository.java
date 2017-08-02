package ctrlseries.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ctrlseries.ws.model.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Long>{

}
