package cl.duoc.videogames.controller;

import cl.duoc.videogames.dto.CompanieDTO;
import cl.duoc.videogames.service.CompanieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/companie")
public class CompanieController {

    private final CompanieService companieService;

    public CompanieController(CompanieService companieService) {
        this.companieService = companieService;
    }

    @PostMapping
    public ResponseEntity<CompanieDTO> create(@RequestBody CompanieDTO companieDTO) {
        return ResponseEntity.ok(companieService.create(companieDTO));
    }

    @GetMapping
    public ResponseEntity<List<CompanieDTO>> findAll() {
        return ResponseEntity.ok(companieService.findAll());
    }
}
