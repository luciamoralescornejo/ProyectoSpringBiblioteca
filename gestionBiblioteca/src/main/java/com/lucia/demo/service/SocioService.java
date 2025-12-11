package com.lucia.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.lucia.demo.exception.SocioNoEncontradoException;
import com.lucia.demo.modelo.Socio;
import com.lucia.demo.repository.SocioRepository;

/**
 * Servicio que gestiona la lógica de negocio relacionada con socios.
 * Permite listar, obtener, guardar y eliminar socios en la base de datos.
 * Lanza SocioNoEncontradoException si se intenta acceder a un socio
 * inexistente.
 * Utiliza SocioRepository para realizar operaciones de persistencia.
 * Se marca con @Service para que Spring lo inyecte automáticamente en los
 * controladores.
 */
@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    // LISTAR SOCIOS
    public List<Socio> listarSocios() {
        return socioRepository.findAll();
    }

    // OBTENER UNO POR ID
    public Socio obtenerSocioPorId(Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new SocioNoEncontradoException("Socio con id " + id + " no encontrado"));
    }

    // GUARDAR (NUEVO O EDITADO)
    public Socio guardarSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    // ELIMINAR
    public void eliminarSocio(Long id) {
        if (!socioRepository.existsById(id)) {
            throw new SocioNoEncontradoException("No existe socio con id " + id);
        }
        socioRepository.deleteById(id);
    }
}