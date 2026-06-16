# Medi Connect Resources

Repositorio que contiene los microservicios encargados de gestionar los recursos principales del sistema de citas médicas.

---

## 🧩 Descripción

Este repositorio agrupa los servicios base del sistema:

* 👤 Pacientes
* 🩺 Doctores

Estos microservicios almacenan y gestionan la información fundamental que posteriormente es utilizada por el sistema de gestión de citas médicas.

---

## 📦 Microservicios incluidos

### 🔹 ms-pacientes

Microservicio encargado de la administración de pacientes.

Funciones principales:

* Crear pacientes
* Listar pacientes
* Buscar pacientes por ID
* Actualizar información
* Eliminar pacientes

---

### 🔹 ms-doctores

Microservicio encargado de la administración de doctores.

Funciones principales:

* Crear doctores
* Listar doctores
* Buscar doctores por ID
* Actualizar información
* Eliminar doctores

---

## 🛠️ Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven
* Docker
* Swagger/OpenAPI
* JUnit 5
* Mockito

---

## 🧱 Arquitectura

Este repositorio forma parte de una arquitectura basada en microservicios, donde cada servicio opera de manera independiente y especializada.

### Características

* ✔ Bajo acoplamiento
* ✔ Alta cohesión
* ✔ Escalabilidad independiente
* ✔ Fácil mantenimiento
* ✔ Mayor tolerancia a fallos

---

## 💾 Persistencia

Los microservicios utilizan bases de datos H2 en modo archivo para garantizar la persistencia de la información.

Cada servicio mantiene su propia base de datos, siguiendo el principio de independencia de datos de la arquitectura de microservicios.

### Bases de datos

* Pacientes → H2 Pacientes
* Doctores → H2 Doctores

Esto permite conservar la información incluso después de reiniciar la aplicación o los contenedores Docker.

---

## 📄 Documentación API

Cada microservicio expone documentación interactiva mediante Swagger/OpenAPI.

Esto permite:

* Consultar endpoints disponibles.
* Validar solicitudes REST.
* Probar operaciones sin utilizar herramientas externas.

---

## 🧪 Pruebas Unitarias

Se implementaron pruebas unitarias utilizando:

* JUnit 5
* Mockito

### Pruebas implementadas

#### Pacientes

* Crear paciente.
* Buscar paciente por ID.
* Validación de excepciones.

#### Doctores

* Crear doctor.
* Buscar doctor por ID.
* Validación de excepciones.

Las pruebas permiten validar la lógica de negocio de manera aislada y mejorar la calidad del software.

---

## 🔗 Repositorios relacionados

### 🌐 Gateway / BFF

https://github.com/Matyrawr/medi-connect-gateway

### ⚙️ Core (Citas)

https://github.com/Matyrawr/medi-connect-core

---

## 🧠 Patrones de diseño aplicados

### Repository Pattern

Permite desacoplar el acceso a datos de la lógica de negocio.

### DTO Pattern

Controla la transferencia de información entre capas y servicios.

### Service Layer Pattern

Separa la lógica de negocio del acceso a datos.

### Singleton Pattern

Gestiona eficientemente las instancias administradas por Spring.

---

## 🎯 Justificación técnica

La separación de pacientes y doctores en microservicios permite:

* Reducir dependencias innecesarias.
* Mejorar la estabilidad general del sistema.
* Escalar componentes de forma independiente.
* Facilitar mantenimiento y pruebas.
* Permitir despliegues independientes.

### Ejemplo

Si el servicio de doctores presenta una falla, el servicio de pacientes puede continuar funcionando sin afectar completamente la plataforma.

---

## 🚀 Beneficios

* Código más organizado.
* Mejor mantenibilidad.
* Mayor flexibilidad para futuras mejoras.
* Escalabilidad independiente por servicio.
* Arquitectura preparada para entornos distribuidos.
* Integración sencilla con nuevos microservicios.

---

## ▶️ Ejecución

### Ejecutar microservicio de pacientes

```bash
mvn spring-boot:run
```

### Ejecutar microservicio de doctores

```bash
mvn spring-boot:run
```

### Ejecutar pruebas

```bash
mvn test
```

---
