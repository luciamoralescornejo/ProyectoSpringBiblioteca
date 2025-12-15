package com.lucia.demo.controller;

import com.lucia.demo.modelo.Socio;
import com.lucia.demo.service.SocioService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/socios") // Solo para vistas web
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping
    public String listarSocios(Model model) {
        model.addAttribute("socios", socioService.listarSocios());
        return "socios";
    }

    @GetMapping("/nuevo")
    public String formularioNuevoSocio(Model model) {
        model.addAttribute("socio", new Socio());
        return "nuevoSocio";
    }

    @PostMapping("/guardar") // POST para formulario web
    public String guardarSocio(
            @Valid @ModelAttribute Socio socio,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "nuevoSocio";
        }

        socioService.guardarSocio(socio);
        return "redirect:/socios";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarSocio(@PathVariable Long id, Model model) {
        model.addAttribute("socio", socioService.obtenerSocioPorId(id));
        return "nuevoSocio";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
        return "redirect:/socios";
    }
}