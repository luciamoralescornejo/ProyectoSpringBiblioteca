package com.lucia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucia.demo.modelo.Prestamo;

/**
 * Repositorio JPA para la entidad Prestamo.
 * Permite realizar operaciones CRUD sobre préstamos en la base de datos.
 * Extiende JpaRepository, heredando métodos como save, findAll, findById y
 * delete.
 * Incluye un método personalizado para buscar un préstamo por libro y socio.
 * Se marca con @Repository para que Spring lo gestione automáticamente.
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    /**
     * Busca un préstamo específico por el ID del libro y del socio.
     *
     * @param libroId ID del libro
     * @param socioId ID del socio
     * @return el préstamo correspondiente, si existe
     */
    Prestamo findByLibroIdAndSocioId(Long libroId, Long socioId);
}