package cl.duoc.videogames.controller;

import cl.duoc.videogames.dto.ConsoleDTO;
import cl.duoc.videogames.service.ConsoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/console")
public class ConsoleController {

    private final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @GetMapping
        public ResponseEntity<List<ConsoleDTO>> findAll() {
        return ResponseEntity.ok(consoleService.findAll());
    }

    @PostMapping
    public ResponseEntity<ConsoleDTO> create(@RequestBody ConsoleDTO consoleDTO) {
        return ResponseEntity.ok(consoleService.create(consoleDTO));
    }
}
