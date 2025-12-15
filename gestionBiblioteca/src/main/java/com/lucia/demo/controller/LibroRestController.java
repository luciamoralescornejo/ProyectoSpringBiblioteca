package com.lucia.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucia.demo.service.LibroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/libros")
@Tag(name = "Libros", description = "Operaciones sobre libros de la biblioteca")
public class LibroRestController {

    private final LibroService libroService;

    public LibroRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar libro", description = "Elimina un libro existente por su ID")
    public ResponseEntity<String> borrarLibro(
            @Parameter(description = "ID del libro a eliminar", required = true) @PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.ok("Libro eliminado");
    }
}