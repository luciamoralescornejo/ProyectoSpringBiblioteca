package com.lucia.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para manejar la página de inicio de la aplicación.
 * Redirige la ruta raíz "/" a la vista principal "menu".
 * Utiliza la anotación @Controller para servir vistas HTML.
 */
@Controller
public class InicioController {

    /**
     * Muestra la página de inicio.
     *
     * @return nombre de la vista "menu" que se renderizará
     */
    @GetMapping("/")
    public String inicio() {
        return "menu";
    }
}
