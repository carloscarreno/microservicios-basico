![Header del curso](images/header.png)
# Microservicios Nivel Basico
### Curso Preparado para IGP/Sunat

# Temas del Curso:

## Modulo 1. Introducción a los Microservicios (1h)
### Objetivo: Comprender qué es la arquitectura de microservicios y cuándo aplicarla.
+  ¿Qué es un microservicio? Comparación con el modelo monolítico.
+  Características clave: desacoplamiento, escalabilidad, resiliencia.
+  Beneficios y desafíos de los microservicios.
+  Casos de uso en la industria.


## Modulo 2. Arquitectura de Microservicios (introducción a Arquitectura limpia y hexagonal, DDD SAGA entre otros ) (1h)
### Objetivo: Comprender los principios, componentes y patrones de diseño clave en la arquitectura de microservicios para desarrollar sistemas escalables, resilientes y mantenibles.
+	Evolución de las arquitecturas de software
+	Arquitectura de Microservicios
+	Arquitectura Hexagonal, DDD SAGA vs Arquitectura de Microservicios 


## Modulo 3. Creación de Microservicios con Spring Boot 3.X.X  (1h)
### Objetivo: Aprender a desarrollar microservicios con Spring Boot 3, incluyendo configuración, comunicación entre servicios, seguridad y despliegue
+	Modelo de Referencia de Microservicios
+	Modelo de Implementación de Microservicios con Spring Boot 3.X.X
+	Creación de Microservicios con Sprint Boot 3.X.X

## Modulo 4. Añadiendo Entities  (1.5 h)
### Objetivo: Comprender el concepto de entidades en JPA, cómo definirlas y gestionarlas en aplicaciones Java con persistencia en bases de datos.
+	Definición de una entidad
+	Anotaciones de entidad @Entity, @Table, @Column
+	Estrategia de claves primarias
+	Relaciones entre entidades
+	Consultas 

## Modulo 5. Repositorios con JPA (1.5 h)
### Objetivo: Entender cómo gestionar la persistencia de datos en aplicaciones Java utilizando repositorios JPA, con enfoque en Spring Data JPA para facilitar el acceso a la base de datos.
+	Introducción a Spring Data JPA y JpaRepository
+	Métodos CRUD de JpaRepository
+	Consultas con JpaRepository
+	Paginación y ordenamiento con Spring Data JPA



## Modulo 6. Componente Service (1.5 h)
### Objetivo: Comprender el rol del componente Service en una arquitectura de microservicios, su implementación con Spring Boot y las mejores prácticas. 
+	Responsabilidades del componente Service
+	Implementación del componente Service en Spring Boot
+	Llamada al componente Service
+	Integración del componente Service con otros Microservicios

## Modulo 7. Creando nuestra API REST (1.5 h)
### Objetivo: Comprender los conceptos fundamentales de una API REST, su arquitectura, principios y cómo implementarla en Spring Boot.
+	Arquitectura de un API Rest
+	Métodos de un API Rest
+	Implementación de API Rest en Spring Boot
+	Buenas prácticas en API Rest


## Modulo 8. Probando API con Swagger (1 h)
### Objetivo: Entender cómo documentar y probar APIs REST con Swagger usando Spring Boot.
+	Introducción a Swagger y sus componentes
+	Configurar Swagger en Spring Boot
+	Documentando una API Rest con Swagger
+	Probando la API Rest con Swagger

## Modulo 9. Spring Security (JSON Web Tokens) (2 h)  
### Objetivo: Comprender cómo implementar autenticación con JWT (JSON Web Token) en Spring Boot y proteger APIs REST.
+	Introducción a Json Web Tokens 
+	Configurar JWT con con Spring Boot
+	Implementación de JWT
+	Filtros para interceptar peticiones en JWT
+	Configurar seguridad con Spring Security
+	Endpoint de Autenticacion


## Modulo 10. Registrando Microservicios (Registry con Eureka y Spring Cloud Config) (1.5 h)
### Objetivo: Comprender cómo Eureka y Spring Cloud Config permiten gestionar el descubrimiento de servicios y la configuración centralizada en una arquitectura de microservicios.
+	Introducción al registro de servicios con Eureka.
+	Configurar Eureka Server en Spring Boot
+	Configurar el Eureka Client en Microservicios
+	Configurar Spring Cloud Config Server
+	Configurar un Microservicio como Spring Cloud Config Client

## Modulo 11. El API Gateway (Zuul) (1.5 h)
### Objetivo: Aprender a utilizar Zuul como API Gateway en una arquitectura de microservicios para gestionar rutas, seguridad y balanceo de carga.
+	Configurar Zuul con Spring Boot
+	Implementando Zuul y Microservicios
+	Seguridad de Zuul con JWT
+	Balanceo de carga con Zuul


## Modulo 12. Balanceo de carga con Spring Cloud Load Balancer y Ribbon ( 1h)
### Objetivo: Entender cómo Spring Cloud Load Balancer y Ribbon permiten distribuir tráfico entre instancias de microservicios en una arquitectura distribuida.
+	Configurar Ribbon con Spring Boot
+	Configurar Spring Cloud Load Balancer con Spring Boot
+	Configurar estrategias de balanceo
+	Integrar load Balancer con FeignClient

## Modulo 13. Manejo de errores (Resilient for java) (1 h)
### Objetivo: Implementar estrategias para manejar errores en microservicios de forma eficiente, asegurando resiliencia, trazabilidad y una mejor experiencia de usuario. 
+	Tipos de errores en microservicios
+	Manejo de errores con Spring Boot @ExceptionHandler
+	Personalizando las Excepciones con Spring Boot
+	Implementando el patron Circuit Breaker

## Modulo 14. Log y trazabilidad (Elasticsearch Logstash Kibana) (1h)
### Objetivo: Implementar ELK Stack (Elasticsearch, Logstash, Kibana) para centralizar logs, facilitar la trazabilidad y monitorear microservicios en tiempo real.
+	Configurar logs en Microservicios
+	Configurar logstash para procesar logs
+	Visualizar logs en Kibana
+	Trazabilidad de Microservicios
