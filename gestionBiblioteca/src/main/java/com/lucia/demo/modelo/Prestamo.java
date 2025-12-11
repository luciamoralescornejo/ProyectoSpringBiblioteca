package com.lucia.demo.modelo;

import java.time.LocalDate;
import jakarta.persistence.*;

/**
 * Entidad que representa un préstamo de libro realizado por un socio.
 * Mapea la relación entre Socio y Libro con información de fechas y estado.
 * Contiene campos para fecha de préstamo, inicio, fin y estado del préstamo.
 * Incluye un enum Estado para indicar si el préstamo está activo, devuelto o
 * retrasado.
 */
@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @PrePersist
    public void prePersist() {
        if (fechaPrestamo == null) {
            fechaPrestamo = LocalDate.now();
        }
        if (fechaInicio == null) {
            fechaInicio = LocalDate.now();
        }
    }

    public enum Estado {
        ACTIVO, DEVUELTO, RETRASADO
    }

    // ===== GETTERS Y SETTERS =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}