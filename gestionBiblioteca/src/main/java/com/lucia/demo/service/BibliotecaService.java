package com.lucia.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
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

    public BibliotecaService(LibroRepository libroRepositorio, SocioRepository socioRepositorio,
            PrestamoRepository prestamoRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.socioRepositorio = socioRepositorio;
        this.prestamoRepositorio = prestamoRepositorio;
    }

    // Libros
    public List<Libro> getAllLibros() {
        return libroRepositorio.findAll();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    // Socios
    public List<Socio> getAllSocios() {
        return socioRepositorio.findAll();
    }

    public Socio saveSocio(Socio socio) {
        return socioRepositorio.save(socio);
    }

    // Prestamos
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepositorio.findAll();
    }

    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepositorio.save(prestamo);
    }

}