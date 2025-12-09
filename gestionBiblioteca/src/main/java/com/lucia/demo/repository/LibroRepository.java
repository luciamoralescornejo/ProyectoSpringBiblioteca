package com.lucia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucia.demo.modelo.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}