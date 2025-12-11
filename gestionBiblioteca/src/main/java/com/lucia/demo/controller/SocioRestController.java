package com.lucia.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucia.demo.service.SocioService;

/**
 * Controlador REST para manejar operaciones sobre socios vía API.
 * Permite eliminar socios mediante solicitudes HTTP DELETE.
 * Se mapea con "/api/socios" y utiliza SocioService para la lógica.
 * Todos los métodos devuelven respuestas HTTP con ResponseEntity.
 */
@RestController
@RequestMapping("/api/socios")
public class SocioRestController {

    private final SocioService socioservice;

    /**
     * Constructor que inyecta el servicio de socios.
     *
     * @param socioservice servicio para manejar socios
     */
    public SocioRestController(SocioService socioservice) {
        this.socioservice = socioservice;
    }

    /**
     * Elimina un socio por su ID.
     *
     * @param id id del socio a eliminar
     * @return ResponseEntity con mensaje de éxito
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSocio(@PathVariable Long id) {
        socioservice.eliminarSocio(id);
        return ResponseEntity.ok("Socio eliminado");
    }
}