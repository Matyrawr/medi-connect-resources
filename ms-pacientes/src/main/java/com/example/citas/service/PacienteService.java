package com.example.citas.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.citas.dto.PacienteDTO;
import com.example.citas.model.Paciente;
import com.example.citas.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public PacienteDTO crear(PacienteDTO req) {
        Paciente paciente = new Paciente();
        paciente.setNombre(req.getNombre());
        paciente.setEmail(req.getEmail());
        paciente.setTelefono(req.getTelefono());
        
        Paciente guardado = pacienteRepository.save(paciente);
        return toDto(guardado);
    }

    @Transactional(readOnly = true)
    public List<PacienteDTO> listar() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDTO> response = new ArrayList<>();
        for (Paciente p : pacientes) {
            response.add(toDto(p));
        }
        return response;
    }

    @Transactional(readOnly = true)
    public PacienteDTO buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
    }

    private PacienteDTO toDto(Paciente p) {
        PacienteDTO dto = new PacienteDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setEmail(p.getEmail());
        dto.setTelefono(p.getTelefono());
        return dto;
    }
}