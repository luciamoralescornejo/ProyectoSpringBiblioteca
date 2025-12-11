package com.lucia.demo.exception;

/**
 * Excepción personalizada que se lanza cuando un socio no es encontrado.
 * Extiende RuntimeException, por lo que es una excepción no verificada.
 * Permite enviar un mensaje personalizado describiendo el error.
 * Se utiliza en controladores y servicios de la biblioteca.
 */
public class SocioNoEncontradoException extends RuntimeException {

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param mensaje mensaje que describe la excepción
     */
    public SocioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
