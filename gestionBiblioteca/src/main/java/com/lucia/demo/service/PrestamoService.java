package com.lucia.demo.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.lucia.demo.modelo.Prestamo;
import com.lucia.demo.repository.PrestamoRepository;

/**
 * Servicio que gestiona la lógica de negocio de los préstamos.
 * Permite listar, guardar, obtener, eliminar y devolver préstamos.
 * Calcula fechas por defecto y actualiza el estado del préstamo al devolverlo.
 * Utiliza PrestamoRepository para persistencia en la base de datos.
 * Se marca con @Service para la inyección automática en Spring.
 */
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

    // Guardar o actualizar préstamo
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }

        // Si no tiene fechaPrestamo, ponerla
        if (prestamo.getFechaPrestamo() == null) {
            prestamo.setFechaPrestamo(LocalDate.now());
        }

        // Si no tiene fechaFin, dar 14 días por defecto
        if (prestamo.getFechaFin() == null) {
            prestamo.setFechaFin(LocalDate.now().plusDays(14));
        }

        return prestamoRepository.save(prestamo);
    }

    // Buscar préstamo por ID
    public Prestamo obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    // Eliminar préstamo
    public void eliminarPrestamo(Long id) {
        if (prestamoRepository.existsById(id)) {
            prestamoRepository.deleteById(id);
        }
    }

    // Marcar préstamo como devuelto
    public void devolverPrestamo(Long id) {
        Prestamo p = obtenerPrestamoPorId(id);
        if (p != null) {
            p.setEstado(Prestamo.Estado.DEVUELTO);
            p.setFechaFin(LocalDate.now()); // fecha real devolución
            prestamoRepository.save(p);
        }
    }
}
