# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.joseph.ruc-management' is invalid and this project uses 'com.joseph.rucmanagement' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

# ruc-management

Este es un servicio REST que proporciona tres endpoints para validar un RUC, registrar una persona jurídica con solo su RUC y registrar una persona jurídica con todos sus datos.

## Endpoints

### 1. Validar un RUC

Endpoint para validar si un RUC es válido.

* **URL**: `/validate`
* **Método**: `GET`
* **Parámetros de URL**:
    * `ruc`: cadena de texto con el RUC a validar (requerido).
* **Respuesta satisfactoria**:
    * **Código**: `200 OK`
    * **Contenido**: `true` si el RUC es válido, `false` de lo contrario.
* **Respuesta en caso de error**:
    * **Código**: `400 Bad Request`
    * **Contenido**: objeto JSON con la información del error, ejemplo:
      ```
      {
          "status": "BAD_REQUEST",
          "message": "El RUC es inválido",
          "error": "BAD_REQUEST"
      }
      ```

### 2. Registrar una persona jurídica con solo su RUC

Endpoint para registrar una persona jurídica con solo su RUC.

* **URL**: `/externalRegister`
* **Método**: `POST`
* **Request Param**: ruc : "123456789"
* **Respuesta satisfactoria**:
* **Código**: `201 Created`
* **Respuesta en caso de error**:
* **Código**: `400 Bad Request`
* **Contenido**: objeto JSON con la información del error, ejemplo:
  ```
  {
      "status": "BAD_REQUEST",
      "message": "El RUC es inválido",
      "error": "BAD_REQUEST"
  }
  ```

### 3. Registrar una persona jurídica con todos sus datos

Endpoint para registrar una persona jurídica con todos sus datos.

* **URL**: `/register`
* **Método**: `POST`
* **Cuerpo de la solicitud**: objeto JSON con la siguiente estructura:
* {
  "ruc": "12345678901",
  "razonSocial": "Mi Empresa S.A.C.",
  "estado": "ACTIVO",
  "direccion": "Av. Lima 123",
  "ubigeo": "150101",
  "departamento": "LIMA",
  "provincia": "LIMA",
  "distrito": "LIMA",
  "tipo": 2
  }
* **Respuesta satisfactoria**:
* **Código**: `201 Created`
* **Respuesta en caso de error**:
* **Código**: `400 Bad Request`
* **Contenido**: objeto JSON con la información del error, ejemplo:
  ```
  {
      "status": "BAD_REQUEST",
      "message": "El RUC es inválido",
      "error": "BAD_REQUEST"
  }
  ```
###  4. Réplica de la base de datos
Si deseas replicar la base de datos MongoDB utilizada por el servicio ruc-management en un entorno local o remoto, puedes seguir los siguientes pasos:

* Asegúrate de tener instalado MongoDB en tu sistema. Puedes descargarlo desde su página oficial.

* Crea una nueva base de datos llamada ruc-management y crea una collection llamada legal_entities
* Puedes llenarla manualmente o si gustas puedes intentar probar los endpoints de registrar personas juridicas para llenar sus datos
