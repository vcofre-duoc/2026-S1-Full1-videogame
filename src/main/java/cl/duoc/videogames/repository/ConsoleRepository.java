package cl.duoc.videogames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.videogames.model.Console;

public interface ConsoleRepository extends JpaRepository<Console, Long>{

}
