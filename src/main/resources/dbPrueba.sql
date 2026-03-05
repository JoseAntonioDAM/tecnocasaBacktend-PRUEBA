CREATE DATABASE pruebabackbasica;
USE DATABASE pruebabackbasica;
/*
Hola chicos, aquí José Antonio;
Para poder hacer que funcione este archivo, en vuestra shell o workbench ejecutais este y sercioraros de seleccionar la base de
datos si esto no lo hace automáticamente.

*/
 # Véase aquí tablas de ejemplo: 
 
-- 1. Tabla Rol
CREATE TABLE IF NOT EXISTS rol (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL -- Administrador, Agente, Cliente
);

-- 2. Tabla Ubicación
CREATE TABLE IF NOT EXISTS Ubicación (
    id_ubicacion INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(150),
    Ciudad VARCHAR(100),
    Pais VARCHAR(100)
);

-- 3. Tabla Suelos
CREATE TABLE IF NOT EXISTS Suelos (
    id_suelo INT AUTO_INCREMENT PRIMARY KEY,
    Tipo_suelo VARCHAR(100)
);

-- 4. Tabla precio
CREATE TABLE IF NOT EXISTS precio (
    id_precio INT AUTO_INCREMENT PRIMARY KEY,
    moneda VARCHAR(10),
    monto DECIMAL(10,2)
);