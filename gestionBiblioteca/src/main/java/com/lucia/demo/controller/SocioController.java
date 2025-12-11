package com.lucia.demo.controller;

import com.lucia.demo.modelo.Socio;
import com.lucia.demo.service.SocioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    // LISTAR SOCIOS ------------------------------------------------------
    @GetMapping
    public String listarSocios(Model model) {
        model.addAttribute("socios", socioService.listarSocios());
        return "socios";
    }

    // FORMULARIO NUEVO SOCIO --------------------------------------------
    @GetMapping("/nuevo")
    public String formularioNuevoSocio(Model model) {
        model.addAttribute("socio", new Socio());
        return "nuevoSocio";
    }

    // GUARDAR SOCIO (NUEVO O EDITADO) -----------------------------------
    @PostMapping("/guardar")
    public String guardarSocio(@ModelAttribute Socio socio) {
        socioService.guardarSocio(socio);
        return "redirect:/socios";
    }

    // FORMULARIO EDITAR SOCIO -------------------------------------------
    @GetMapping("/editar/{id}")
    public String formularioEditarSocio(@PathVariable Long id, Model model) {
        model.addAttribute("socio", socioService.obtenerSocioPorId(id));
        return "nuevoSocio";
    }

    // ELIMINAR SOCIO -----------------------------------------------------
    @GetMapping("/eliminar/{id}")
    public String eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
        return "redirect:/socios";
    }
}