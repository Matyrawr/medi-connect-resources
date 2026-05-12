package com.example.citas.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citas.dto.PacienteDTO;
import com.example.citas.service.PacienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }


    @PostMapping
    public ResponseEntity<PacienteDTO> crear(@RequestBody PacienteDTO req) {
        PacienteDTO nuevo = pacienteService.crear(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    // GET /{id}: Para buscar uno solo
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPorId(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}