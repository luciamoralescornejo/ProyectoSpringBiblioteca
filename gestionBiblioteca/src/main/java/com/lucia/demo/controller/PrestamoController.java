package com.lucia.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucia.demo.modelo.Libro;
import com.lucia.demo.modelo.Prestamo;
import com.lucia.demo.modelo.Socio;
import com.lucia.demo.service.LibroService;
import com.lucia.demo.service.PrestamoService;
import com.lucia.demo.service.SocioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;
    private final LibroService libroService;
    private final SocioService socioService;

    public PrestamoController(
            PrestamoService prestamoService,
            LibroService libroService,
            SocioService socioService) {
        this.prestamoService = prestamoService;
        this.libroService = libroService;
        this.socioService = socioService;
    }

    @GetMapping
    public String listarPrestamos(
            @RequestParam(required = false) Long socioId,
            Model model) {

        List<Prestamo> prestamos;

        if (socioId != null) {
            prestamos = prestamoService.listarPrestamosPorSocio(socioId);
        } else {
            prestamos = prestamoService.listarPrestamos();
        }

        model.addAttribute("prestamos", prestamos);
        model.addAttribute("socios", socioService.listarSocios());
        model.addAttribute("socioSeleccionado", socioId);

        return "prestamos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioPrestamo(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("libros", libroService.listarLibros());
        model.addAttribute("socios", socioService.listarSocios());
        return "nuevoPrestamo";
    }

    @PostMapping("/guardar")
    public String guardarPrestamo(
            @Valid @ModelAttribute Prestamo prestamo,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("libros", libroService.listarLibros());
            model.addAttribute("socios", socioService.listarSocios());
            return "nuevoPrestamo";
        }

        Libro libro = libroService.obtenerLibroPorId(prestamo.getLibro().getId());
        Socio socio = socioService.obtenerSocioPorId(prestamo.getSocio().getId());

        prestamo.setLibro(libro);
        prestamo.setSocio(socio);
        prestamo.setEstado(Prestamo.Estado.ACTIVO);

        prestamoService.guardarPrestamo(prestamo);

        return "redirect:/prestamos";
    }

    @GetMapping("/devolver/{id}")
    public String devolverPrestamo(@PathVariable Long id) {
        prestamoService.devolverPrestamo(id);
        return "redirect:/prestamos";
    }
}
