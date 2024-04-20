<h1 align="center">Seguro Mortuorio Backend</h1>

<p align="center">
  <img src="https://example.com/your-logo.png" alt="Logo" width="150" height="150">
</p>

<p align="center">
  <strong>API RESTful para el sistema de seguro mortuorio</strong>
</p>

## Descripción

Seguro Mortuorio Backend es la API RESTful que alimenta el sistema de seguro mortuorio. Desarrollado con Spring Boot, proporciona la lógica de negocio y los servicios necesarios para la gestión de pagos, socios, reportes y usuarios.

## Configuración

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener Java y Maven instalados.
3. Configura la URL de la base de datos, el usuario y la contraseña en el archivo `application.properties`.

Una vez que hayas configurado el archivo `application.properties` con los datos de tu base de datos, puedes ejecutar el proyecto. Al iniciar la aplicación, ten en cuenta lo siguiente:

- 🛠️ Si has configurado JPA para que genere automáticamente las tablas, estas se crearán si no existen en la base de datos al iniciar la aplicación.
  
- 🔧 Si has realizado cambios en las entidades JPA o en la configuración de la base de datos, es posible que necesites utilizar herramientas como Hibernate DDL para actualizar manualmente el esquema de la base de datos.

La API estará disponible en `http://localhost:8080` una vez que el proyecto esté en ejecución.

## Frontend

El frontend de esta aplicación se encuentra en el repositorio [Seguro Mortuorio Frontend](https://github.com/Bailon18/seguromortuorio-front). Asegúrate de clonarlo y configurarlo correctamente para que funcione con este backend.

## Ejecución

Para ejecutar el proyecto, utiliza el siguiente comando:

```bash
./mvnw spring-boot:run

