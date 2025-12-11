package com.lucia.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucia.demo.service.SocioService;

@RestController
@RequestMapping("/api/socios")
public class SocioRestController {

    private final SocioService socioservice;

    public SocioRestController(SocioService socioservice) {
        this.socioservice = socioservice;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSocio(@PathVariable Long id) {
        socioservice.eliminarSocio(id);
        return ResponseEntity.ok("Socio eliminado");
    }
}
