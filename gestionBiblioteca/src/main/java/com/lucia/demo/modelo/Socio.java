package com.lucia.demo.modelo;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Entidad que representa un socio de la biblioteca.
 * Mapea la tabla correspondiente en la base de datos con JPA.
 * Contiene atributos como nombre, email, fecha de fin de penalización y
 * préstamos.
 * Mantiene una relación uno a muchos con Prestamo, ignorada en JSON.
 */
@Entity
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "fechaFinPenalizacion")
    private LocalDate fechaFinPenalizacion;

    @JsonIgnore
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestamo> prestamos;

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFinPenalizacion() {
        return fechaFinPenalizacion;
    }

    public void setFinPenalizacion(LocalDate fechaFinPenalizacion) {
        this.fechaFinPenalizacion = fechaFinPenalizacion;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}