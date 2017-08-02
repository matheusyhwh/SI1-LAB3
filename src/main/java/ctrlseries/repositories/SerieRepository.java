package ctrlseries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ctrlseries.objects.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

}
