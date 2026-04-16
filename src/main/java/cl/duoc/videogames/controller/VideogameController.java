package cl.duoc.videogames.controller;

import cl.duoc.videogames.dto.VideogameDTO;
import cl.duoc.videogames.service.VideogameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/videogame")
public class VideogameController {

    private final VideogameService videogameService;

    public VideogameController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }
    
    @GetMapping
    public ResponseEntity<List<VideogameDTO>> findAll() {
        return ResponseEntity.ok(videogameService.findAll());
    }

    @PostMapping
    public ResponseEntity<VideogameDTO> create(@RequestBody VideogameDTO videogameDTO) {
        return ResponseEntity.ok(videogameService.create(videogameDTO));
    }


}
