package cl.duoc.videogames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.videogames.model.Videogame;

public interface VideogameRepository extends JpaRepository<Videogame, Long>{

}
