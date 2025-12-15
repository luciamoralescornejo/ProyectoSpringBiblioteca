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

import com.lucia.demo.modelo.Libro;
import com.lucia.demo.service.LibroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public String listarLibros(Model model) {
        List<Libro> libros = libroService.listarLibros();
        model.addAttribute("libros", libros);
        return "libros";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioLibro(Model model) {
        model.addAttribute("libro", new Libro());
        return "nuevoLibro";
    }

    @PostMapping("/guardar")
    public String guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores, devolvemos al formulario original
            if (libro.getId() != null) {
                return "editarLibro"; // estamos editando
            } else {
                return "nuevoLibro"; // estamos creando
            }
        }
        libroService.guardarLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Libro libro = libroService.obtenerLibroPorId(id);
        model.addAttribute("libro", libro);
        return "editarLibro";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return "redirect:/libros";
    }
}
