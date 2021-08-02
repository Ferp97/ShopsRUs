# ShopsRUs
Prueba Tecnica II Fernanda Porras


**PASOS**

1. Clonar la aplicación

https://github.com/Ferp97/ShopsRUs.git


2. Crear la base de datos en PostgreSQL 

create database proyecto;


3. Cambiar el usuario y la contraseña de la base de datos de acuerdo a tu instalacion

Abrir src/main/resources/application.properties

Cambiar 
spring.datasource.username = 
spring.datasource.password =
Ingresar el usuario y la contraseña de acuerdo a la instalacion de la computadora

4. Construya y corra la aplicación utilizando Maven

mvn package
java -jar target/spring-boot-rest-api-tutorial-0.0.1-SNAPSHOT.jar
Alternatively, you can run the app without packaging it using -

mvn spring-boot:run

La aplicacion va a correr por defecto en la URL http://localhost:8080.

Explorar las Rest APIs

GET http://localhost:8080/api/clientes"

GET http://localhost:8080/api/clienteId/{id}" 

GET http://localhost:8080/api/clienteNombre/{nombre}"

POST http://localhost:8080/api/cliente

GET http://localhost:8080/api/descuento

PUT http://localhost:8080/api/descuento

