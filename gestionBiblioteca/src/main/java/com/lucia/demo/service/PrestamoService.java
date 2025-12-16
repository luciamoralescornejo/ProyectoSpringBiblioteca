package com.lucia.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lucia.demo.exception.PrestamoNoEncontradoException;
import com.lucia.demo.modelo.Prestamo;
import com.lucia.demo.repository.PrestamoRepository;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    // Listar todos los préstamos
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    // Listar préstamos por socio (ACTIVOS + DEVUELTOS + RETRASADOS)
    public List<Prestamo> listarPrestamosPorSocio(Long socioId) {
        return prestamoRepository.findBySocioId(socioId);
    }

    // Guardar o actualizar préstamo
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }

        if (prestamo.getFechaPrestamo() == null) {
            prestamo.setFechaPrestamo(LocalDate.now());
        }

        if (prestamo.getFechaFin() == null) {
            prestamo.setFechaFin(LocalDate.now().plusDays(14));
        }

        return prestamoRepository.save(prestamo);
    }

    // Buscar préstamo por ID
    public Prestamo obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id)
                .orElseThrow(() -> new PrestamoNoEncontradoException(
                        "No se ha encontrado el préstamo con id " + id));
    }

    // Devolver préstamo
    public void devolverPrestamo(Long id) {
        Prestamo prestamo = obtenerPrestamoPorId(id);
        prestamo.setEstado(Prestamo.Estado.DEVUELTO);
        prestamo.setFechaFin(LocalDate.now());
        prestamoRepository.save(prestamo);
    }
}
