package com.lucia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucia.demo.modelo.Prestamo;

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
