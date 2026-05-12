package com.example.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.citas.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
