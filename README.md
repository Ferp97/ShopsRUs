# ShopsRUs
Prueba Tecnica II Fernanda Porras


**PASOS**

1. Clonar la aplicación

https://github.com/Ferp97/ShopsRUs.git


2. Crear la base de datos en PostgreSQL 

create database proyecto;

3. Darle permisos de su usuario a la base de datos 

grant all privileges on database proyecto to SU_USUARIO;

4. Cambiar el usuario y la contraseña de la base de datos de acuerdo a tu instalacion

Abrir src/main/resources/application.properties

Cambiar 
spring.datasource.username = 
spring.datasource.password =
Ingresar el usuario y la contraseña de acuerdo a la instalacion de la computadora

5. Construya y corra la aplicación utilizando Maven


La aplicacion va a correr por defecto en la URL http://localhost:8080.

Explorar las Rest APIs

GET http://localhost:8080/api/clientes"

GET http://localhost:8080/api/clienteId/{id}" 

GET http://localhost:8080/api/clienteNombre/{nombre}"

POST http://localhost:8080/api/clientes

GET http://localhost:8080/api/descuento

PUT http://localhost:8080/api/descuento

GET http://localhost:8080/api/factura

GET http://localhost:8080/api/facturaId/{id}

PUT http://localhost:8080/api/factura

