package com.lucia.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucia.demo.modelo.Socio;
import com.lucia.demo.repository.SocioRepository;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public List<Socio> listarSocios() {
        return socioRepository.findAll();
    }

    public Socio obtenerSocioPorId(Long id) {
        return socioRepository.findById(id).orElse(null);
    }
}
