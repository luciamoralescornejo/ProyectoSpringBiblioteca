package com.lucia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucia.demo.modelo.Socio;

/**
 * Repositorio JPA para la entidad Socio.
 * Permite realizar operaciones CRUD sobre socios en la base de datos.
 * Extiende JpaRepository, heredando métodos como save, findAll, findById y
 * delete.
 * Se marca con @Repository para que Spring lo detecte y maneje la inyección de
 * dependencias.
 */
@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

}
