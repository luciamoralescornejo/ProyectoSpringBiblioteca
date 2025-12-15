package com.lucia.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.lucia.demo.modelo.Libro;
import com.lucia.demo.modelo.Prestamo;
import com.lucia.demo.modelo.Socio;
import com.lucia.demo.service.BibliotecaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class BibliotecaController {

    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    // ====================== LIBROS ======================

    @GetMapping("/libros")
    @Operation(summary = "Obtiene todos los libros")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de libros obtenida correctamente")
    })
    public ResponseEntity<List<Libro>> getAllLibros() {
        return ResponseEntity.ok(service.getAllLibros());
    }

    @PostMapping("/libros")
    @Operation(summary = "Crea un nuevo libro")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Libro creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Errores de validación")
    })
    public ResponseEntity<Libro> crearLibro(
            @Parameter(description = "Libro a crear") @Valid @RequestBody Libro libro) {
        Libro saved = service.saveLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ====================== SOCIOS ======================

    @GetMapping("/socios")
    @Operation(summary = "Obtiene todos los socios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de socios obtenida correctamente")
    })
    public ResponseEntity<List<Socio>> getAllSocios() {
        return ResponseEntity.ok(service.getAllSocios());
    }

    @PostMapping("/socios")
    @Operation(summary = "Crea un nuevo socio")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Socio creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Errores de validación")
    })
    public ResponseEntity<Socio> crearSocio(
            @Parameter(description = "Socio a crear") @Valid @RequestBody Socio socio) {
        Socio saved = service.saveSocio(socio);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ====================== PRÉSTAMOS ======================

    @GetMapping("/prestamos")
    @Operation(summary = "Obtiene todos los préstamos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de préstamos obtenida correctamente")
    })
    public ResponseEntity<List<Prestamo>> getAllPrestamos() {
        return ResponseEntity.ok(service.getAllPrestamos());
    }

    @PostMapping("/prestamos")
    @Operation(summary = "Crea un nuevo préstamo")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Préstamo creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Errores de validación")
    })
    public ResponseEntity<Prestamo> crearPrestamo(
            @Parameter(description = "Préstamo a crear") @Valid @RequestBody Prestamo prestamo) {
        Prestamo saved = service.savePrestamo(prestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}