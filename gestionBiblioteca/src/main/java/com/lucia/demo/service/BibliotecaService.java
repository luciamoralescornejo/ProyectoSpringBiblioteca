package com.lucia.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.lucia.demo.exception.LibroNoEncontradoException;
import com.lucia.demo.exception.PrestamoNoEncontradoException;
import com.lucia.demo.exception.SocioNoEncontradoException;
import com.lucia.demo.modelo.Libro;
import com.lucia.demo.modelo.Prestamo;
import com.lucia.demo.modelo.Socio;
import com.lucia.demo.repository.LibroRepository;
import com.lucia.demo.repository.PrestamoRepository;
import com.lucia.demo.repository.SocioRepository;

/**
 * Servicio que gestiona la lógica de negocio de la biblioteca.
 * Proporciona operaciones para libros, socios y préstamos.
 * Utiliza repositorios JPA para acceder a la base de datos.
 * Permite obtener todos los registros y guardar nuevas entidades.
 * Se marca con @Service para la inyección automática de Spring.
 */

@Service
public class BibliotecaService {

    private final LibroRepository libroRepositorio;
    private final SocioRepository socioRepositorio;
    private final PrestamoRepository prestamoRepositorio;

    public BibliotecaService(LibroRepository libroRepositorio,
            SocioRepository socioRepositorio,
            PrestamoRepository prestamoRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.socioRepositorio = socioRepositorio;
        this.prestamoRepositorio = prestamoRepositorio;
    }

    // ---------- Libros ----------

    public List<Libro> getAllLibros() {
        return libroRepositorio.findAll();
    }

    public Libro getLibroById(Long id) {
        return libroRepositorio.findById(id)
                .orElseThrow(() -> new LibroNoEncontradoException(
                        "No se ha encontrado el libro con id " + id));
    }

    public Libro saveLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    public void deleteLibro(Long id) {
        if (!libroRepositorio.existsById(id)) {
            throw new LibroNoEncontradoException(
                    "No se puede eliminar: el libro no existe");
        }
        libroRepositorio.deleteById(id);
    }

    // ---------- Socios ----------

    public List<Socio> getAllSocios() {
        return socioRepositorio.findAll();
    }

    public Socio getSocioById(Long id) {
        return socioRepositorio.findById(id)
                .orElseThrow(() -> new SocioNoEncontradoException(
                        "No se ha encontrado el socio con id " + id));
    }

    public Socio saveSocio(Socio socio) {
        return socioRepositorio.save(socio);
    }

    // ---------- Préstamos ----------

    public List<Prestamo> getAllPrestamos() {
        return prestamoRepositorio.findAll();
    }

    public Prestamo getPrestamoById(Long id) {
        return prestamoRepositorio.findById(id)
                .orElseThrow(() -> new PrestamoNoEncontradoException(
                        "No se ha encontrado el préstamo con id " + id));
    }

    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepositorio.save(prestamo);
    }
}