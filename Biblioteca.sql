DROP DATABASE IF EXISTS gestion_biblioteca;

CREATE DATABASE gestion_biblioteca;

USE gestion_biblioteca;

CREATE TABLE Socio (
	socio_id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50),
    apellidos VARCHAR(50),
    email VARCHAR(100) UNIQUE, 
    fechaNacimiento DATE, 
    fechaAlta DATE, 
    estado ENUM('ACTIVO', 'SANCIONADO'), 
    fechaFinPenalizacion DATE NULL
);

CREATE TABLE Libro (
	libro_id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    categoria VARCHAR(50),
    isbn VARCHAR(13) UNIQUE
);

CREATE TABLE Prestamo (
	prestamo_id INT AUTO_INCREMENT PRIMARY KEY,
    socio_id INT REFERENCES Socio(socio_id),
    libro_id INT REFERENCES Libro(libro_id),
	fechaPrestamo DATETIME, 
    fechaLimite DATETIME, 
    fechaDevolucio DATETIME NULL
);