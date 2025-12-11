package com.lucia.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucia.demo.service.LibroService;

/**
 * Controlador REST para manejar operaciones sobre libros vía API.
 * Proporciona endpoints para eliminar libros usando solicitudes HTTP.
 * Se mapea con "/api/libros" y utiliza LibroService para la lógica.
 * Todos los métodos devuelven respuestas HTTP con ResponseEntity.
 */
@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

    private final LibroService libroService;

    /**
     * Constructor que inyecta el servicio de libros.
     *
     * @param libroService servicio que maneja la lógica de libros
     */
    public LibroRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Elimina un libro por su ID.
     *
     * @param id id del libro a eliminar
     * @return ResponseEntity con mensaje de éxito
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.ok("Libro eliminado");
    }
}
