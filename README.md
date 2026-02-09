🎨 Sistema de Soporte Operacional – Artes Luis Studio
📌 Descripción del Proyecto
El proyecto Artes Luis Studio es una solución de software orientada a la gestión operativa y administrativa, desarrollada como parte del curso Lenguajes de Programación de la Universidad Tecnológica del Perú (UTP), correspondiente al Ciclo Verano 2026.

El núcleo del sistema es un microservicio desarrollado en Scala encargado de la gestión de usuarios, roles y control de accesos, diseñado para integrarse con una plataforma web existente y optimizar la seguridad y escalabilidad de la empresa.

🏫 Contexto Académico
Curso: Lenguajes de Programación

Universidad: Universidad Tecnológica del Perú (UTP)

Ciclo: Verano 2026

Docente: Ivan Robles Fernandez

Caso de negocio: Soporte Operacional para Gestión de Usuarios

Este proyecto se desarrolla bajo un enfoque ágil (Scrum), organizado en cuatro sprints, utilizando Scala como lenguaje principal y GitHub como plataforma de colaboración y control de versiones.

🎯 Objetivo del Proyecto
Implementar un microservicio robusto que permita la administración eficiente de la seguridad de Artes Luis Studio, facilitando:

La gestión centralizada de usuarios y roles.

El control de accesos mediante servicios REST.

La modularidad del sistema mediante una arquitectura de microservicios.

La aplicación de programación funcional y herramientas modernas como sbt e IntelliJ IDEA.

📦 Alcance y Funcionalidades
El sistema contempla las siguientes capacidades técnicas:

🔐 Módulo de Autenticación: Validación de credenciales para el inicio de sesión.

👥 Gestión de Roles: Asignación de permisos diferenciados (Admin, Operador, etc.).

🌐 Servicios REST: Endpoints para la comunicación entre el frontend y el microservicio.

📁 Persistencia de Datos: Almacenamiento estructurado de información de usuarios y perfiles.

📄 Formato JSON: Intercambio de datos estandarizado para todas las respuestas del API.

🛠️ Tecnologías Utilizadas
Lenguaje: Scala 2.13 / 3.x

Gestor de Construcción: sbt (Scala Build Tool)

IDE: IntelliJ IDEA

Control de Versiones: Git & GitHub

Formato de Datos: JSON

📁 Estructura del Repositorio
Basado en el estándar de proyectos Scala/sbt:

Plaintext
Lenguaje-de-programacion-Grupo-3/
│
├── project/                # Configuración de sbt (build.properties)
├── src/
│   ├── main/
│   │   ├── scala/          # Código fuente del Microservicio
│   │   │   └── com/artesluis/
│   │   │       ├── controller/  # Controladores de los Endpoints
│   │   │       ├── model/       # Definición de Clases y Entidades
│   │   │       ├── service/     # Lógica de Negocio
│   │   │       └── Main.scala   # Punto de entrada de la aplicación
│   │   └── resources/      # Archivos de configuración (application.conf)
│   └── test/               # Pruebas unitarias y de integración
│
├── .gitignore              # Archivos excluidos de Git
├── build.sbt               # Configuración de dependencias del proyecto
└── README.md               # Documentación del proyecto


🚀 Metodología de Trabajo
El desarrollo se realiza mediante Sprints con entregas incrementales:

Sprint 1: Configuración de entorno, repositorio y estructura base.

Sprint 2: Implementación de la lógica del microservicio y modelos.

Sprint 3: Desarrollo de servicios REST y conectividad.

Sprint 4: Pruebas finales, validación JSON y documentación técnica.

Se utiliza una estrategia de ramas (main, develop, feature/) y Pull Requests para asegurar la calidad del código mediante revisiones por pares.

📊 Estado del Proyecto
🟡 Sprint 1: Finalizado / Configuración Inicial ⚪ Sprint 2: En planificación

👨‍💻 Autores (Grupo 3)
Ñiquen Neciosup, Luis Edilberto

Ramos Bautista, John Luis

Mejia Crisostomo, Javier Eduardo

Bruno Santiago, Reyes Vixce
