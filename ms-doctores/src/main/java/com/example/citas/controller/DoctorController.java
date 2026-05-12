package com.example.citas.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.citas.dto.DoctorDTO;
import com.example.citas.service.DoctorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/doctores")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // POST: Crear doctor
    @PostMapping
    public ResponseEntity<DoctorDTO> crear(@RequestBody DoctorDTO req) {
        DoctorDTO nuevo = doctorService.crear(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // GET: Listar todos (Evita el error 405 en el navegador)
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> listar() {
        return ResponseEntity.ok(doctorService.listar());
    }

    // GET /{id}: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(doctorService.buscarPorId(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}