package com.example.citas.dto;

import java.time.LocalTime;

public class DoctorDTO {
    private Long id;
    private String nombre;
    private String especialidad;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer duracionCita;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }
    public Integer getDuracionCita() { return duracionCita; }
    public void setDuracionCita(Integer duracionCita) { this.duracionCita = duracionCita; }
}
