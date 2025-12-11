package com.lucia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucia.demo.modelo.Libro;

/**
 * Repositorio JPA para la entidad Libro.
 * Permite realizar operaciones CRUD sobre libros en la base de datos.
 * Extiende JpaRepository, heredando métodos como save, findAll, findById y
 * delete.
 * Se marca con @Repository para que Spring lo detecte y maneje la inyección de
 * dependencias.
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
