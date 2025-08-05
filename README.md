# CRUD API con Spring Boot 3

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-green)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-orange)](https://www.mysql.com/)
[![JPA](https://img.shields.io/badge/JPA-Hibernate-purple)](https://hibernate-org.translate.goog/orm/?_x_tr_sl=en&_x_tr_tl=es&_x_tr_hl=es&_x_tr_pto=tc).

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
Devuelve una lista paginada en formato JSON de todos los usuarios.

Para configurar la paginación, agregue los siguientes parámetros a la URL:

`?page=0&size=10&sort=id`

Explicacion detallada de los parámetros:
`?page=0` Indica cual pagina mostrar (Comienza desde 0).
`?size=10`  Especifica la cantidad de elementos por página.
`?sort=id` Define el campo por el cual se ordenarán los resultados.
- Responses:
	- `200 OK`  Devuelve la lista paginada de los usuarios.

### GET `/api/user/{id}`
Devuelve un JSON con la información del usuario con el ID correspondiente.
- Responses:
	- `400 Bad Request` Si no existe un usuario con el id ingresado.
	- `200 OK` Devuelve el usuario perteneciente al ID ingresado.

### POST `/api/user`
Permite crear un nuevo objeto usuario en la base de datos. Para ello, debemos pasar un JSON con el siguiente formato:
```
{
    "name":"Saul",
    "lastName":"Pérez",
    "birthdayDate":"2002-06-20"
}
```
El ID se generará automáticamente, por lo que no es necesario ingresar un ID desde el JSON.
- Responses:
	- `400 Bad Request` Si ingresamos mal o nos falta completar un campo, devolverá el campo del JSON con error.
	- `200 OK` Usuario creado en la base de datos.

### POST `/api/user/bulk`
Crea múltiples usuarios en una sola solicitud. Formato del cuerpo:
```
[
	{
		"name":"Sofia",
		"lastName":"Lopez",
		"birthdayDate":"2010-12-12"
	},
	{
		"name":"Alejandro",
		"lastName":"Silva",
		"birthdayDate":"2005-09-10"
	},
	{
		"name":"Saul",
		"lastName":"Álvarez",
		"birthdayDate":"1998-10-03"
	}
]
```
Los IDs se generará automáticamente, por lo que no es necesario ingresarlos desde el JSON.
- Responses:
	- `400 Bad Request` Si hay errores de validación en los campos.
	- `201 Created` Usuarios creados en la base de datos.

### PUT `/api/user/{id}`
Actualiza un usuario existente.
 Ejemplo: `/api/user/2`
```
{
    "name":"Saul",
    "lastName":"Pérez",
    "birthdayDate":"2002-06-20"
}
```
- Responses:
	- `400 Bad Request` Si no existe el usuario con el ID especificado.
	- `200 OK` Usuario actualizado.

### DELETE `/api/user/{id}`
Elimina a un usuario.

 Ejemplo: `/api/user/2`
- Responses:
	- `400 Bad Request` Si no existe el usuario con el ID especificado.
	- `200 OK` Usuario eliminado.

## Requisitos
- Java 17+
- Maven 3.6+
- MySQL 8.0+
- Postman o cualquier cliente para probar la API.

## Instalación
1. Clonar el repositorio:
```
git clone https://github.com/Alexander-Sot23/JavaSpringCRUD.git
cd JavaSpringCRUD
```
2.	Configurar las propiedades de la aplicación en `application.properties`.
```
spring.datasource.url=jdbc/:mysql://localhost:3306/tu_basedatos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```
3.	Construir y ejecutar la aplicación:
```
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`
