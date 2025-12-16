package com.lucia.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LibroNoEncontradoException.class)
    public Object handleLibroNoEncontrado(
            LibroNoEncontradoException ex,
            HttpServletRequest request) {

        String accept = request.getHeader("Accept");

        // Cliente REST
        if (accept != null && accept.contains("application/json")) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());
        }

        // Cliente MVC
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("mensaje", ex.getMessage());
        return mv;
    }

    /**
     * Maneja la excepción SocioNoEncontradoException.
     */
    @ExceptionHandler(SocioNoEncontradoException.class)
    public Object handleSocioNoEncontrado(
            SocioNoEncontradoException ex,
            HttpServletRequest request) {

        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());
        }

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("mensaje", ex.getMessage());
        return mv;
    }

    /**
     * Maneja errores generales no controlados.
     */
    @ExceptionHandler(Exception.class)
    public Object handleGenericException(
            Exception ex,
            HttpServletRequest request) {

        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor");
        }

        ModelAndView mv = new ModelAndView("error");
        mv.addObject("mensaje", "Ha ocurrido un error inesperado");
        return mv;
    }
}
