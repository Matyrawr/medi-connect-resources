package com.example.citas.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.citas.dto.DoctorDTO;
import com.example.citas.model.Doctor;
import com.example.citas.repository.DoctorRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    public DoctorDTO crear(DoctorDTO req) {
        Doctor doctor = new Doctor();
        doctor.setNombre(req.getNombre());
        doctor.setEspecialidad(req.getEspecialidad());
        doctor.setHoraInicio(req.getHoraInicio());
        doctor.setHoraFin(req.getHoraFin());
        doctor.setDuracionCita(req.getDuracionCita());
        
        Doctor guardado = doctorRepository.save(doctor);
        return toDto(guardado);
    }

    @Transactional(readOnly = true)
    public List<DoctorDTO> listar() {
        List<Doctor> doctores = doctorRepository.findAll();
        List<DoctorDTO> response = new ArrayList<>();
        for (Doctor d : doctores) {
            response.add(toDto(d));
        }
        return response;
    }

    @Transactional(readOnly = true)
    public DoctorDTO buscarPorId(Long id) {
        return doctorRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Doctor no encontrado"));
    }

    private DoctorDTO toDto(Doctor d) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(d.getId());
        dto.setNombre(d.getNombre());
        dto.setEspecialidad(d.getEspecialidad());
        dto.setHoraInicio(d.getHoraInicio());
        dto.setHoraFin(d.getHoraFin());
        dto.setDuracionCita(d.getDuracionCita());
        return dto;
    }
}