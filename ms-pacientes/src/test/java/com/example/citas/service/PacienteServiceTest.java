package com.example.citas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.citas.dto.PacienteDTO;
import com.example.citas.model.Paciente;
import com.example.citas.repository.PacienteRepository;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    void crearGuardaYDevuelvePacienteDTO() {
        PacienteDTO request = new PacienteDTO();
        request.setNombre("Isabel");
        request.setEmail("isabel@example.com");
        request.setTelefono("933060007");

        Paciente saved = new Paciente();
        saved.setId(1L);
        saved.setNombre(request.getNombre());
        saved.setEmail(request.getEmail());
        saved.setTelefono(request.getTelefono());

        when(pacienteRepository.save(org.mockito.ArgumentMatchers.any(Paciente.class))).thenReturn(saved);

        PacienteDTO response = pacienteService.crear(request);

        assertEquals(1L, response.getId());
        assertEquals("Isabel", response.getNombre());
        assertEquals("isabel@example.com", response.getEmail());
        assertEquals("933060007", response.getTelefono());

        ArgumentCaptor<Paciente> captor = ArgumentCaptor.forClass(Paciente.class);
        verify(pacienteRepository).save(captor.capture());
        assertEquals("Isabel", captor.getValue().getNombre());
    }

    @Test
    void buscarPorIdCuandoNoExisteLanzaExcepcion() {
        when(pacienteRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> pacienteService.buscarPorId(99L));
    }
}