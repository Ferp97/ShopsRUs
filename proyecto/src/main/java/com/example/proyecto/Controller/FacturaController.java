package com.example.proyecto.Controller;

import com.example.proyecto.Model.Factura;
import com.example.proyecto.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/factura")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> getFacturas(){
        return facturaService.getFacturas();
    }

    @GetMapping(path = "/facturaId/{id}")
    public Factura getFacturaById(@PathVariable("id") Long id) {
        return facturaService.findById(id);
    }

    @PostMapping
    public void agregarNuevaFactura(@RequestBody Factura factura){
        facturaService.agregarNuevaFactura(factura);
    }
}
