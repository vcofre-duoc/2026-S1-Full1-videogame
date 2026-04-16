package cl.duoc.videogames.service;

import org.springframework.stereotype.Service;

import cl.duoc.videogames.dto.ConsoleDTO;
import cl.duoc.videogames.model.Companie;
import cl.duoc.videogames.model.Console;
import cl.duoc.videogames.repository.CompanieRepository;
import cl.duoc.videogames.repository.ConsoleRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para manejar la lógica de consolas.
 */
@Service
public class ConsoleService {

    private final ConsoleRepository consoleRepository;
    private final CompanieRepository companieRepository;

    public ConsoleService(ConsoleRepository consoleRepository, CompanieRepository companieRepository) {
        this.consoleRepository = consoleRepository;
        this.companieRepository = companieRepository;
    }

    /**
     * Listar todas las consolas registradas.
     */
    public List<ConsoleDTO> findAll() {
        return consoleRepository.findAll()
                .stream()
                .map(c -> new ConsoleDTO(c.getId(), c.getName(), c.getReleaseYear(), null))
                .collect(Collectors.toList());
    }
    
    /**
     * Crear una nueva consola en la base de datos.
     */
    public ConsoleDTO create(ConsoleDTO consoleDTO) {
        Console console = new Console();
        console.setName(consoleDTO.getName());
        console.setReleaseYear(consoleDTO.getReleaseYear());

        // Buscar la compañía por ID y asignarla
        if (consoleDTO.getCompanie() != null && consoleDTO.getCompanie().getId() != null) {
            Companie companie = companieRepository.findById(consoleDTO.getCompanie().getId())
                    .orElseThrow(() -> new RuntimeException("Companie not found"));
            console.setCompanie(companie);
        } else {
            throw new RuntimeException("Companie ID is required");
        }

        console = consoleRepository.save(console);
        consoleDTO.setId(console.getId());
        return consoleDTO;
    }
}