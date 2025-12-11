package com.lucia.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucia.demo.modelo.Libro;
import com.lucia.demo.service.LibroService;

/**
 * Controlador para manejar la gestión de libros en la aplicación.
 * Permite listar, crear, editar y eliminar libros usando vistas HTML.
 * Utiliza LibroService para la lógica de negocio.
 * Se mapea con "/libros" y maneja formularios y redirecciones.
 */
@Controller
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    /**
     * Constructor que inyecta el servicio de libros.
     *
     * @param libroService servicio para manejar libros
     */
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Muestra la lista de libros.
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "libros" con la lista de libros
     */
    @GetMapping
    public String listarLibros(Model model) {
        List<Libro> libros = libroService.listarLibros();
        model.addAttribute("libros", libros);
        return "libros";
    }

    /**
     * Muestra el formulario para crear un nuevo libro.
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "nuevoLibro" con un objeto Libro vacío
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioLibro(Model model) {
        model.addAttribute("libro", new Libro());
        return "nuevoLibro";
    }

    /**
     * Guarda un libro nuevo o actualizado.
     *
     * @param libro objeto Libro enviado desde el formulario
     * @return redirección a "/libros"
     */
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroService.guardarLibro(libro);
        return "redirect:/libros";
    }

    /**
     * Muestra el formulario para editar un libro existente.
     *
     * @param id    id del libro a editar
     * @param model objeto Model para pasar datos a la vista
     * @return vista "editarLibro" con el libro correspondiente
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Libro libro = libroService.obtenerLibroPorId(id);
        model.addAttribute("libro", libro);
        return "editarLibro";
    }

    /**
     * Elimina un libro existente.
     *
     * @param id id del libro a eliminar
     * @return redirección a "/libros"
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return "redirect:/libros";
    }
}
