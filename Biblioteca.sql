DROP DATABASE IF EXISTS gestion_biblioteca;
CREATE DATABASE gestion_biblioteca;
USE gestion_biblioteca;

-- TABLA SOCIO
CREATE TABLE Socio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL,
    fechaNacimiento DATE DEFAULT NULL,
    fecha_alta DATE NOT NULL DEFAULT current_timestamp,
    estado ENUM('ACTIVO','SANCIONADO') NOT NULL DEFAULT 'ACTIVO',
    fechaFinPenalizacion DATE DEFAULT NULL
);

-- TABLA LIBRO
CREATE TABLE Libro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100),
    categoria VARCHAR(50),
    isbn VARCHAR(13) UNIQUE NOT NULL
);

-- TABLA PRESTAMO
CREATE TABLE Prestamo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    socio_id BIGINT NOT NULL,
    libro_id BIGINT NOT NULL,
    fecha_inicio DATETIME NOT NULL,
    fecha_fin DATETIME NOT NULL,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE NULL,
    estado ENUM('ACTIVO','DEVUELTO','RETRASADO') NOT NULL DEFAULT 'ACTIVO',

    FOREIGN KEY (socio_id) REFERENCES Socio(id),
    FOREIGN KEY (libro_id) REFERENCES Libro(id)
);

-- INSERTAR DATOS INICIALES

-- SOCIOS
INSERT INTO Socio (nombre, apellidos, email, fechaNacimiento, estado, fechaFinPenalizacion)
VALUES
('Lucía', 'Gómez Pérez', 'lucia@example.com', '1995-03-12', 'ACTIVO', NULL),
('Carlos', 'Fernández Ruiz', 'carlos@example.com', '1988-07-20', 'ACTIVO', NULL),
('Ana', 'Martínez Soto', 'ana@example.com', '2000-11-05', 'ACTIVO', NULL),
('Javier', 'Santos Molina', 'javier@example.com', '1992-02-28', 'SANCIONADO', DATE_ADD(CURDATE(), INTERVAL 5 DAY)),
('María', 'López Ortega', 'maria@example.com', '1985-10-10', 'ACTIVO', NULL);

-- LIBROS
INSERT INTO Libro (titulo, autor, categoria, isbn)
VALUES
('Cien Años de Soledad', 'Gabriel García Márquez', 'Novela', '9780307474728'),
('El Quijote', 'Miguel de Cervantes', 'Clásico', '9788491050295'),
('1984', 'George Orwell', 'Distopía', '9780451524935'),
('La Sombra del Viento', 'Carlos Ruiz Zafón', 'Misterio', '9788408172173'),
('Harry Potter y la Piedra Filosofal', 'J.K. Rowling', 'Fantasía', '9788478884452'),
('El Señor de los Anillos', 'J.R.R. Tolkien', 'Fantasía', '9780618640157');

-- PRESTAMOS 
INSERT INTO Prestamo (socio_id, libro_id, fecha_inicio, fecha_fin, fecha_prestamo, fecha_devolucion, estado)
VALUES
(1, 1, '2025-12-01 10:00:00', '2025-12-15 23:59:59', '2025-12-01', NULL, 'ACTIVO'),
(2, 3, '2025-11-20 09:30:00', '2025-12-04 23:59:59', '2025-11-20', '2025-12-02', 'DEVUELTO'),
(3, 2, '2025-12-05 16:45:00', '2025-12-19 23:59:59', '2025-12-05', NULL, 'ACTIVO'),
(4, 5, '2025-11-25 12:10:00', '2025-12-09 23:59:59', '2025-11-25', NULL, 'RETRASADO'),
(5, 4, '2025-12-06 15:20:00', '2025-12-20 23:59:59', '2025-12-06', NULL, 'ACTIVO');

DROP DATABASE gestion_biblioteca; 