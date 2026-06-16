package com.example.citas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.citas.dto.DoctorDTO;
import com.example.citas.model.Doctor;
import com.example.citas.repository.DoctorRepository;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    void crearGuardaYDevuelveDoctorDTO() {
        DoctorDTO request = new DoctorDTO();
        request.setNombre("Javier");
        request.setEspecialidad("Cardiologia");
        request.setHoraInicio(LocalTime.of(8, 0));
        request.setHoraFin(LocalTime.of(17, 0));
        request.setDuracionCita(30);

        Doctor saved = new Doctor();
        saved.setId(1L);
        saved.setNombre(request.getNombre());
        saved.setEspecialidad(request.getEspecialidad());
        saved.setHoraInicio(request.getHoraInicio());
        saved.setHoraFin(request.getHoraFin());
        saved.setDuracionCita(request.getDuracionCita());

        when(doctorRepository.save(org.mockito.ArgumentMatchers.any(Doctor.class))).thenReturn(saved);

        DoctorDTO response = doctorService.crear(request);

        assertEquals(1L, response.getId());
        assertEquals("Javier", response.getNombre());
        assertEquals("Cardiologia", response.getEspecialidad());
        assertEquals(LocalTime.of(8, 0), response.getHoraInicio());
        assertEquals(LocalTime.of(17, 0), response.getHoraFin());
        assertEquals(30, response.getDuracionCita());

        ArgumentCaptor<Doctor> captor = ArgumentCaptor.forClass(Doctor.class);
        verify(doctorRepository).save(captor.capture());
        assertEquals("Cardiologia", captor.getValue().getEspecialidad());
    }

    @Test
    void buscarPorIdCuandoNoExisteLanzaExcepcion() {
        when(doctorRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> doctorService.buscarPorId(99L));
    }
}