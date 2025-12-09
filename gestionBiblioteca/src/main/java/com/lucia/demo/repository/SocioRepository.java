package com.lucia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucia.demo.modelo.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

}