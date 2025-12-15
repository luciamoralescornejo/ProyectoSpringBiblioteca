package com.lucia.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * Manejador global de excepciones para la aplicación.
 * Captura excepciones específicas y las procesa de manera centralizada.
 * Actualmente maneja LibroNoEncontradoException mostrando una vista de error.
 * Utiliza @ControllerAdvice para aplicar la gestión a todos los controladores.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja la excepción LibroNoEncontradoException.
     *
     * @param ex excepción lanzada cuando no se encuentra un libro
     * @return ModelAndView con la vista "error" y mensaje de la excepción
     */
    @ExceptionHandler(LibroNoEncontradoException.class)
    public ModelAndView handleLibroNotFound(LibroNoEncontradoException ex) {
        ModelAndView mv = new ModelAndView("error"); 
        mv.addObject("mensaje", ex.getMessage());
        return mv;
    }
}
