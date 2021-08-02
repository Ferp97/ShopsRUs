package com.example.proyecto.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @SequenceGenerator(
            name = "factura_sequence",
            sequenceName = "factura_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "factura_sequence"
    )
    private Long idFactura;
    private Long idCliente;
    private String tipoDescuento;
    private LocalDate fechaFactura;
    private float total;


    public Factura() {
    }

    public Factura( Long idCliente, LocalDate fechaFactura, float total) {
        this.idCliente = idCliente;
        this.fechaFactura = fechaFactura;
        this.total = total;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
