package com.example.proyecto.Service;

import com.example.proyecto.Model.Cliente;
import com.example.proyecto.Model.Descuento;
import com.example.proyecto.Model.Factura;
import com.example.proyecto.Repository.ClienteRepository;
import com.example.proyecto.Repository.DescuentoRepository;
import com.example.proyecto.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> getFacturas(){
        return facturaRepository.findAll();
    }

    public Factura findById(long id) {
        List<Factura> facturas = getFacturas();
        for (Factura factura: facturas) {
            if (factura.getIdFactura() == id) {
                return factura;
            }
        }
        return null;
    }

    ClienteService clienteService;
    DescuentoRepository descuentoRepository;


    public void agregarNuevaFactura(Factura factura){
        Optional<Factura> facturaById =  facturaRepository
                .findById(factura.getIdFactura());
        if (facturaById.isPresent()){
            throw new IllegalStateException("La factura ya existe.");
        }else{
            Cliente infoCliente = new Cliente();
            List<Cliente> clientes = clienteService.getClientes();
            for (Cliente cliente: clientes) {
                if (cliente.getId() == factura.getIdCliente()) {
                    infoCliente = cliente;
                }
            }
            String tipoDescuento = infoCliente.getTipoCliente();
            factura.setTipoDescuento(tipoDescuento);

        }
        facturaRepository.save(factura);
    }



}
