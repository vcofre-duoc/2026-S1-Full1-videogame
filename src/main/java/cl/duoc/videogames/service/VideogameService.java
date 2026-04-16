package cl.duoc.videogames.service;

import org.springframework.stereotype.Service;

import cl.duoc.videogames.dto.VideogameDTO;
import cl.duoc.videogames.model.Console;
import cl.duoc.videogames.model.Videogame;
import cl.duoc.videogames.repository.ConsoleRepository;
import cl.duoc.videogames.repository.VideogameRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Servicio para manejar la lógica de videojuegos.
 */
@Service
public class VideogameService {

    private final VideogameRepository videogameRepository;
    private final ConsoleRepository consoleRepository;

    public VideogameService(VideogameRepository videogameRepository, ConsoleRepository consoleRepository) {
        this.videogameRepository = videogameRepository;
        this.consoleRepository = consoleRepository;
    }

        
    /**
     * Listar todos los videojuegos registrados.
     */
    public List<VideogameDTO> findAll() {
        return videogameRepository.findAll()
                .stream()
                .map(v -> new VideogameDTO(v.getId(), v.getTitle(), v.getGenre(),
                        v.getReleaseYear(), v.getDeveloper(), null))
                .collect(Collectors.toList());
    }
    
    /**
     * Crear un nuevo videojuego en la base de datos.
     */
    public VideogameDTO create(VideogameDTO videogameDTO) {
        Videogame videogame = new Videogame();
        videogame.setTitle(videogameDTO.getTitle());
        videogame.setGenre(videogameDTO.getGenre());
        videogame.setReleaseYear(videogameDTO.getReleaseYear());
        videogame.setDeveloper(videogameDTO.getDeveloper());

        if (videogameDTO.getConsoles() != null) {
            Set<Console> consoles = videogameDTO.getConsoles().stream()
                    .map(c -> consoleRepository.findById(c.getId())
                            .orElseThrow(() -> new RuntimeException("Console not found")))
                    .collect(Collectors.toSet());

            videogame.setConsoles(consoles);
        }

        videogame = videogameRepository.save(videogame);
        videogameDTO.setId(videogame.getId());
        return videogameDTO;
    }

}