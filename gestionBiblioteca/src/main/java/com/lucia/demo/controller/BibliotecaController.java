package com.lucia.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucia.demo.modelo.Libro;
import com.lucia.demo.modelo.Prestamo;
import com.lucia.demo.modelo.Socio;
import com.lucia.demo.service.BibliotecaService;

@RestController
@RequestMapping("/api")
public class BibliotecaController {

    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    // Libros
    @GetMapping("/libros")
    public List<Libro> getAllLibros() {
        return service.getAllLibros();
    }

    @PostMapping("/libros")
    public Libro crearLibro(@RequestBody Libro libro) {
        return service.saveLibro(libro);
    }

    // Socios
    @GetMapping("/socios")
    public List<Socio> getAllSocios() {
        return service.getAllSocios();
    }

    @PostMapping("/socios")
    public Socio crearSocio(@RequestBody Socio socio) {
        return service.saveSocio(socio);
    }

    // Prestamos
    @GetMapping("/prestamos")
    public List<Prestamo> getAllPrestamos() {
        return service.getAllPrestamos();
    }

    @PostMapping("/prestamos")
    public Prestamo crearPrestamo(@RequestBody Prestamo prestamo) {
        return service.savePrestamo(prestamo);
    }
}
