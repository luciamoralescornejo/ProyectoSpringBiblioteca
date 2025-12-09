package com.lucia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucia.demo.modelo.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    // Cambiado socioId por id, que es el campo correcto en Socio
    Prestamo findByLibroIdAndSocioId(Long libroId, Long socioId);
}
