package com.lucia.demo.controller;

import com.lucia.demo.modelo.Socio;
import com.lucia.demo.service.SocioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para gestionar socios de la biblioteca.
 * Permite listar, crear, editar y eliminar socios usando vistas HTML.
 * Utiliza SocioService para la lógica de negocio.
 * Se mapea con "/socios" y maneja formularios y redirecciones.
 */
@Controller
@RequestMapping("/socios")
public class SocioController {

    private final SocioService socioService;

    /**
     * Constructor que inyecta el servicio de socios.
     *
     * @param socioService servicio para manejar socios
     */
    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    /**
     * Muestra la lista de todos los socios.
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "socios" con la lista de socios
     */
    @GetMapping
    public String listarSocios(Model model) {
        model.addAttribute("socios", socioService.listarSocios());
        return "socios";
    }

    /**
     * Muestra el formulario para crear un nuevo socio.
     *
     * @param model objeto Model para pasar datos a la vista
     * @return vista "nuevoSocio" con un objeto Socio vacío
     */
    @GetMapping("/nuevo")
    public String formularioNuevoSocio(Model model) {
        model.addAttribute("socio", new Socio());
        return "nuevoSocio";
    }

    /**
     * Guarda un socio nuevo o editado.
     *
     * @param socio objeto Socio enviado desde el formulario
     * @return redirección a "/socios"
     */
    @PostMapping("/guardar")
    public String guardarSocio(@ModelAttribute Socio socio) {
        socioService.guardarSocio(socio);
        return "redirect:/socios";
    }

    /**
     * Muestra el formulario para editar un socio existente.
     *
     * @param id    id del socio a editar
     * @param model objeto Model para pasar datos a la vista
     * @return vista "nuevoSocio" con los datos del socio correspondiente
     */
    @GetMapping("/editar/{id}")
    public String formularioEditarSocio(@PathVariable Long id, Model model) {
        model.addAttribute("socio", socioService.obtenerSocioPorId(id));
        return "nuevoSocio";
    }

    /**
     * Elimina un socio existente.
     *
     * @param id id del socio a eliminar
     * @return redirección a "/socios"
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
        return "redirect:/socios";
    }
}