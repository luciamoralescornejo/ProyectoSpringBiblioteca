package com.lucia.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LibroNoEncontradoException.class)
    public ModelAndView handleLibroNotFound(LibroNoEncontradoException ex) {
        ModelAndView mv = new ModelAndView("error"); // puedes crear plantilla error.html
        mv.addObject("mensaje", ex.getMessage());
        return mv;
    }
}
