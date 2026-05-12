# Medi Connect Resources

Repositorio que contiene los microservicios encargados de gestionar los recursos principales del sistema de citas médicas.

---

## 🧩 Descripción

Este repositorio agrupa los servicios base del sistema:

- 👤 Pacientes
- 🩺 Doctores

Estos microservicios almacenan y gestionan la información fundamental que luego será utilizada por el sistema de citas.

---

## 📦 Microservicios incluidos

### 🔹 ms-pacientes

Encargado de la gestión de pacientes.

Funciones principales:
- Crear pacientes
- Listar pacientes
- Buscar por ID
- Actualizar información
- Eliminar pacientes

---

### 🔹 ms-doctores

Encargado de la gestión de doctores.

Funciones principales:
- Crear doctores
- Listar doctores
- Buscar por ID
- Actualizar información
- Eliminar doctores

---

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL / H2
- Maven
- Docker

---

## 🧱 Arquitectura

Este repositorio forma parte de una arquitectura de microservicios, donde cada servicio funciona de manera independiente.

✔ Bajo acoplamiento  
✔ Alta cohesión  
✔ Escalabilidad  
✔ Fácil mantenimiento  

---

## 🔗 Repositorios relacionados

- 🌐 Gateway / BFF  
  https://github.com/Matyrawr/medi-connect-gateway  

- ⚙️ Core (Citas + Docker)  
  https://github.com/Matyrawr/medi-connect-core  

---

## 🧠 Patrones de diseño aplicados

- Repository Pattern → acceso a datos desacoplado  
- DTO Pattern → transferencia segura de datos  
- Service Layer → lógica de negocio separada  
- Singleton → gestión eficiente de instancias (Spring Beans)

---

## 🎯 Justificación técnica

La separación de pacientes y doctores en microservicios permite:

- Evitar dependencias innecesarias
- Mejorar la estabilidad del sistema
- Escalar servicios de forma independiente
- Facilitar mantenimiento y pruebas

Ejemplo:
Si el servicio de doctores falla, el sistema de pacientes sigue funcionando.

---

## 🚀 Beneficios

- Código más organizado
- Mejor rendimiento en sistemas distribuidos
- Mayor flexibilidad para futuras mejoras
- Arquitectura preparada para producción
