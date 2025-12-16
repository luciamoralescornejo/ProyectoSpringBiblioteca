package com.lucia.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucia.demo.modelo.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    Prestamo findByLibroIdAndSocioId(Long libroId, Long socioId);

    List<Prestamo> findBySocioId(Long socioId);

    List<Prestamo> findBySocioIdAndEstado(Long socioId, Prestamo.Estado estado);
}
