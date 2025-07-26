# CRUD API con Spring Boot 3

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-green)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-orange)](https://www.mysql.com/)

Una API REST construida con Spring Boot 3 que implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar recursos.

## Características principales

- **Operaciones CRUD completas**: Crear, Leer, Actualizar y Eliminar recursos
- **Validación de datos**: Uso de anotaciones para validar entradas
- **MySQL**: Integración con base de datos relacional MySQL
- **Manejo de excepciones**: Control centralizado de errores
- **Arquitectura limpia**: Separación clara de capas (controlador, servicio, repositorio)


## Tecnologías utilizadas

- **Spring Boot 3**: Framework para aplicaciones Java
- **Spring Data JPA**: Persistencia de datos
- **Maven**: Gestión de dependencias
- **MySQL Database**: Base de datos MySQL
- **Lombok**: Reducción de código

## Endpoints de la API

### GET `/api/user`
Devuelve una lista en formato JSON de todos los usuarios.
- Responses:
	- `200 OK`  Devuelve la lista de todos los usuarios en la base de datos.

### GET `/api/user/{id}`
Devuelve un JSON con la información del usuario con el ID correspondiente..
- Responses:
	- `400 Bad Request` Se obtendrá el error en caso de que no exista el usuario con el ID ingresado.
	- `200 OK` Devuelve el usuario perteneciente al ID ingresado.

### POST `/api/user`
Permite crear un nuevo objeto usuario en la base de datos. Para ello, debemos pasar un JSON con el siguiente formato:
```
{
    "name":"Saul",
    "lastName":"PP",
    "birthdayDate":"2002-06-20"
}
```
El ID se generará automáticamente, por lo que no es necesario ingresar un ID desde el JSON.
- Responses:
	- `400 Bad Request` Si ingresamos mal o nos falta completar un campo, devolverá el campo del JSON con error.
	- `200 OK` Usuario creado en la base de datos.

### PUT `/api/user/{id}`
Permite actualizar un objeto de la base de datos. Solo debemos especificar en la ruta el ID del usuario a modificar, además de pasar nuestro nuevo objeto de la clase Usuario.
 Ejemplo: `/api/user/2`
```
{
    "name":"Saul",
    "lastName":"Pérez",
    "birthdayDate":"2002-06-20"
}
```
- Responses:
	- `400 Bad Request`Se obtendrá el error en caso de que no exista el usuario con el ID ingresado.
	- `200 OK` Usuario actualizado.

### DELETE `/api/user/{id}`
Elimina un usuario de la base de datos. Para realizarlo, debemos especificar en la ruta el {id} del usuario a eliminar.
 Ejemplo: `/api/user/2`
- Responses:
	- `400 Bad Request` Se obtendrá el error en caso de que no exista el usuario con el ID ingresado.
	- `200 OK` Usuario eliminado.


## Estructura del proyecto
src/main/java
├── com/example/crud
│   ├── controller      # Controladores REST
│   ├── entity          # Entidades JPA
│   ├── repository      # Repositorios Spring Data
│   ├── service         # Lógica de negocio
│   └── JavaSpringCRUD.java # Clase principal

## Requisitos
- Java 17+
- Maven 3.6+
- Postman o cualquier cliente para probar la API.

## Instalación
1. Clonar el repositorio:
```
git clone https://github.com/Alexander-Sot23/JavaSpringCRUD.git
cd JavaSpringCRUD
```
2.	Configurar las propiedades de la aplicación en `application.properties`.
3.	Construir y ejecutar la aplicación:
```
mvn spring-boot:run
```
