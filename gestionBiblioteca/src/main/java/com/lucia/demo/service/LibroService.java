package com.lucia.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucia.demo.exception.LibroNoEncontradoException;
import com.lucia.demo.modelo.Libro;
import com.lucia.demo.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new LibroNoEncontradoException("Libro con id " + id + " no encontrado"));
    }
}
