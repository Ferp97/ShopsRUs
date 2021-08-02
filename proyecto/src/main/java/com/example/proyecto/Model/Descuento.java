package com.example.proyecto.Model;

import javax.persistence.*;

@Entity
@Table(name = "descuento")
public class Descuento {

        @Id
        @SequenceGenerator(
                name = "descuento_sequence",
                sequenceName = "descuento_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "descuento_sequence"
        )
        private Long id;
        private double porcentaje;
        private String nombreDescuento;

    public Descuento() {
    }

    public Descuento(double porcentaje, String nombreDescuento) {
        this.porcentaje = porcentaje;
        this.nombreDescuento = nombreDescuento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombreDescuento() {
        return nombreDescuento;
    }

    public void setNombreDescuento(String nombreDescuento) {
        this.nombreDescuento = nombreDescuento;
    }
}
