package com.lucia.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucia.demo.modelo.Socio;
import com.lucia.demo.service.SocioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/gestion-socios") // Cambiado para evitar conflicto
@Tag(name = "Socios", description = "Operaciones sobre socios de la biblioteca")
public class SocioRestController {

    private final SocioService socioService;

    public SocioRestController(SocioService socioService) {
        this.socioService = socioService;
    }

    @Operation(summary = "Listar todos los socios", description = "Devuelve la lista completa de socios")
    @GetMapping
    public ResponseEntity<Iterable<Socio>> listarSocios() {
        return ResponseEntity.ok(socioService.listarSocios());
    }

    @Operation(summary = "Crear un nuevo socio", description = "Crea un nuevo socio en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Socio creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Errores de validación")
    })
    @PostMapping
    public ResponseEntity<Socio> crearSocio(@Valid @RequestBody Socio socio) {
        return ResponseEntity.ok(socioService.guardarSocio(socio));
    }

    @Operation(summary = "Eliminar un socio por ID", description = "Elimina un socio existente de la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Socio eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Socio no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
        return ResponseEntity.ok("Socio eliminado");
    }

    @Operation(summary = "Obtener un socio por ID", description = "Devuelve un socio según su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Socio encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Socio no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Socio> obtenerSocio(@PathVariable Long id) {
        Socio socio = socioService.obtenerSocioPorId(id);
        return ResponseEntity.ok(socio);
    }
}