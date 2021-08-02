package com.example.proyecto.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @SequenceGenerator(
            name = "cliente_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cliente_sequence"
    )
    private Long id;
    private int identificacion;
    private String nombre;
    private LocalDate fechaCreacion;
    private String tipoCliente;

    @Transient
    private int tiempoCliente;

    public Cliente() {
    }

    public Cliente(int identificacion, String nombre, LocalDate fechaCreacion, String tipoCliente) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.tipoCliente = tipoCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getTiempoCliente() {
        return Period.between(fechaCreacion, LocalDate.now()).getYears();
    }

    public void setTiempoCliente(int tiempoCliente) {
        this.tiempoCliente = tiempoCliente;
    }
}
