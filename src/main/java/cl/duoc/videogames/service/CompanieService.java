package cl.duoc.videogames.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.duoc.videogames.dto.CompanieDTO;
import cl.duoc.videogames.model.Companie;
import cl.duoc.videogames.repository.CompanieRepository;

/**
 * Servicio para manejar la lógica de compañías.
 */
@Service
public class CompanieService {

    private final CompanieRepository companieRepository;

    public CompanieService(CompanieRepository companieRepository) {
        this.companieRepository = companieRepository;
    }

    /**
     * Listar todas las compañías registradas.
     */
    public List<CompanieDTO> findAll() {
        return companieRepository.findAll()
                .stream()
                .map(c -> new CompanieDTO(c.getId(), c.getName(), c.getCountry()))
                .collect(Collectors.toList());        
    }
    
    /**
     * Crear una nueva compañía en la base de datos.
     */
    public CompanieDTO create(CompanieDTO companieDTO) {
        Companie companie = new Companie();
        companie.setName(companieDTO.getName());
        companie.setCountry(companieDTO.getCountry());
        companie = companieRepository.save(companie);
        companieDTO.setId(companie.getId());
        return companieDTO;
    }
}