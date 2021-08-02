package com.example.proyecto.Service;

import com.example.proyecto.Model.Descuento;
import com.example.proyecto.Repository.ClienteRepository;
import com.example.proyecto.Repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescuentoService {

    private final DescuentoRepository descuentoRepository;

    @Autowired
    public DescuentoService(DescuentoRepository descuentoRepository) {
        this.descuentoRepository = descuentoRepository;
    }

    public List<Descuento> getDescuentos(){
        return descuentoRepository.findAll();
    }

    public void agregarNuevoDescuento(Descuento descuento){
        Optional<Descuento> descuentoByNombreDescuento =  descuentoRepository
                .findByNombreDescuento(descuento.getNombreDescuento());
        if (descuentoByNombreDescuento.isPresent()){
            throw new IllegalStateException("El descuento ya existe.");
        }
        descuentoRepository.save(descuento);
    }
}
