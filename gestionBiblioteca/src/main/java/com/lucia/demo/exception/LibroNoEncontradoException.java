package com.lucia.demo.exception;

/**
 * Excepción personalizada que se lanza cuando un libro no es encontrado.
 * Extiende RuntimeException, por lo que es una excepción no verificada.
 * Permite enviar un mensaje personalizado describiendo el error.
 * Se utiliza en controladores y servicios de la biblioteca.
 */
public class LibroNoEncontradoException extends RuntimeException {

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param mensaje mensaje que describe la excepción
     */
    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
