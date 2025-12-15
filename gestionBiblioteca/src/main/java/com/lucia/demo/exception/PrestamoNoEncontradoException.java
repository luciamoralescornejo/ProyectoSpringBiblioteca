package com.lucia.demo.exception;

public class PrestamoNoEncontradoException extends RuntimeException {
    public PrestamoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
