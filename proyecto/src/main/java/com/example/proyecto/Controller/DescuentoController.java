package com.example.proyecto.Controller;

import com.example.proyecto.Model.Descuento;
import com.example.proyecto.Service.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/descuento")
public class DescuentoController {

    private final DescuentoService descuentoService;

    @Autowired
    public DescuentoController(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    @GetMapping
    public List<Descuento> getDescuentos(){
        return descuentoService.getDescuentos();
    }

    @PostMapping
    public void agregarNuevoDescuento(@RequestBody Descuento descuento){
        descuentoService.agregarNuevoDescuento(descuento);
    }
}
